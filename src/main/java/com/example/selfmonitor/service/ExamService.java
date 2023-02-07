package com.example.selfmonitor.service;

import com.example.selfmonitor.dao.repository.ExamRepository;
import com.example.selfmonitor.model.entity.Exam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository repository;

    Exam exam;

    //    @PostConstruct
    void init() {
        this.exam = repository.save(new Exam("UPSC", LocalDate.of(2023, 5, 28)));
        System.out.println("Your " + exam.getName() + " is on " + exam.getDate());
    }

    public Optional<Exam> get() {
        return repository.findById(1L);
    }

}
