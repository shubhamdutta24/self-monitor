package com.example.selfmonitor.dao.repository;

import com.example.selfmonitor.model.entity.Exam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends CrudRepository<Exam, Long> {
}