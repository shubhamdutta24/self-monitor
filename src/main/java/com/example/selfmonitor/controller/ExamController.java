package com.example.selfmonitor.controller;

import com.example.selfmonitor.dao.repository.ExamRepository;
import com.example.selfmonitor.exception.BookIdMismatchException;
import com.example.selfmonitor.exception.BookNotFoundException;
import com.example.selfmonitor.model.entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @GetMapping
    public Iterable findAll() {
        return examRepository.findAll();
    }

    @GetMapping("/{id}")
    public Exam findOne(@PathVariable Long id) {
        return examRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Exam create(@RequestBody Exam exam) {
        try {
            return examRepository.save(exam);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        examRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        examRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Exam updateBook(@RequestBody Exam exam, @PathVariable Long id) {
        if (exam.getId() != id) {//(!Objects.equals(exam.getId(), id))
            throw new BookIdMismatchException();
        }
        examRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return examRepository.save(exam);
    }
}
