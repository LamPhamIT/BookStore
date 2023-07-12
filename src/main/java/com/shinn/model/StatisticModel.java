package com.shinn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatisticModel {
    private String statisticDate;
    private Float total;
    private String category;
    private String categoryName;
    private int num;
}
