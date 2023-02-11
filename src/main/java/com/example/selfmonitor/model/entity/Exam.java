package com.example.selfmonitor.model.entity;

import com.example.selfmonitor.model.Score;
import com.example.selfmonitor.model.Time;
import com.example.selfmonitor.model.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate date;

    private List<Topic> topics;

    private Time preparationTime;

    private Time revisionTime;

    private int targetScore;

    private Score scoreDetails;

    public Exam(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

}