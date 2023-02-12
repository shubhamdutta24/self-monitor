package com.example.selfmonitor.model.entity;

import com.example.selfmonitor.ennumeration.StudyType;
import com.example.selfmonitor.model.Task;
import com.example.selfmonitor.model.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private LocalDate from;

    @Column(nullable = false)
    private LocalDate to;

    private StudyDuration dailyStudyDuration;
    private Map<Topic, String> topicsMap;//details like when to study, how much, for what etc.
    private Map<StudyType, Double> studyTypePercentage;
    private Task otherTask;
    private Map<Topic, String> backlogMap;
    private String blockers;
    private String remedy;

    private Double percentageDone;// actual achievement of plan.

}