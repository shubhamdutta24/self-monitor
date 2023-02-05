package com.example.selfmonitor.service;

import com.example.selfmonitor.dao.repository.StudyDurationRepository;
import com.example.selfmonitor.model.entity.StudyDuration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyDurationService {
    private final StudyDurationRepository repository;

    public Optional<StudyDuration> get() {
        return repository.findById(1L);
    }

}
