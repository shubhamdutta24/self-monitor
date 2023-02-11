package com.example.selfmonitor.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * author: Shubham
 * This class stores various score details for examination.
 */
public class Score {

    private Map<LocalDate, Integer> cutoffMarks;
    private Map<LocalDate, Integer> topperScore;
    private Map<LocalDate, List<String>> otherScoreDetails;

}