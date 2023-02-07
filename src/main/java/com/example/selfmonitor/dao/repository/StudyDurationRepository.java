package com.example.selfmonitor.dao.repository;

import com.example.selfmonitor.model.entity.StudyDuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyDurationRepository extends CrudRepository<StudyDuration, Long> {
}