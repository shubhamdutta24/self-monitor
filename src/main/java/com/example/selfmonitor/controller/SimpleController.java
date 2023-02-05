package com.example.selfmonitor.controller;

import com.example.selfmonitor.dao.repository.ExamRepository;
import com.example.selfmonitor.dao.repository.StudyDurationRepository;
import com.example.selfmonitor.model.entity.Exam;
import com.example.selfmonitor.model.entity.StudyDuration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
@RequiredArgsConstructor
public class SimpleController {
    private final ExamRepository repository;
    private final StudyDurationRepository studyDurationRepository;

    @Value("${spring.application.name}")
    String appName;

    Exam exam = new Exam("UPSC", LocalDate.of(2023, 5, 28));
    StudyDuration studyDuration = new StudyDuration();

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
//        model.addAttribute("exam", exam);
        return "home";
    }

    @GetMapping("/exam")
    public String examPage(Model model) {
        exam = repository.findAll().iterator().next();
        LocalDate date = exam.getDate();
        LocalDate today = LocalDate.now();
        model.addAttribute("examName", exam.getName());
        model.addAttribute("examDays", today.until(date, ChronoUnit.DAYS));
        model.addAttribute("studyPlan", studyDuration);
        return "exam";
    }

    @PostMapping("/saveExams")
    public String saveExam(@ModelAttribute Exam exam, BindingResult errors, Model model) {
        this.exam = repository.save(exam);
        return "redirect:/exam";
    }

    @PostMapping("/saveStudyPlan")
    public String saveStudyPlan(@ModelAttribute StudyDuration studyDuration, BindingResult errors, Model model) {
        this.studyDuration = studyDurationRepository.save(studyDuration);
        return "redirect:/exam";
    }

    @PostMapping("/saveFeedback")
    public String saveFeedback(@ModelAttribute StudyDuration actualHrs, BindingResult errors, Model model) {
        this.studyDuration.setActual(actualHrs.getActual());
//        this.studyDuration = studyDurationRepository.save(studyDuration);
        return "redirect:/result";
    }

    @GetMapping("/feedback")
    public String feedbackPage(Model model) {
        StudyDuration duration = new StudyDuration();
        duration.setActual(studyDuration.getActual());
        model.addAttribute("actualHrs", duration);
        model.addAttribute("studyPlan", studyDuration);
        return "feedback";
    }

    @GetMapping("/result")
    public String resultPage(Model model) {
        String string = "a Dissapointment";
        if (studyDuration.getActual() >= studyDuration.getCurrent()) {
            string = "Awesome";
        }
        model.addAttribute("string", string);
        return "result";
    }
}
