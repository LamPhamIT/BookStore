package com.shinn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AbstractModel {
    private Long id;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Long modifiedBy;
    private Timestamp deletedDad;
}
