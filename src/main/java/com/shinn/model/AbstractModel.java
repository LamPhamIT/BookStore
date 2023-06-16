package com.shinn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AbstractModel<T> implements Serializable {
    private Long id;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Long modifiedBy;
    private Timestamp deletedDade;
    private Long[] ids;
    private List<T> listResult = new ArrayList<>();
    private Integer page;
    private Integer maxPageItem;
    private String sortBy;
    private String sortName;
    private int totalPage;
    private Integer totalItem;
}
