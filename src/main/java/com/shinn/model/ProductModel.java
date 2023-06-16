package com.shinn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductModel extends AbstractModel{
    private String title;
    private String thumbnail;
    private String description;
    private Long price;
    private Long discount;
    private int remainQuality;
    private CategoryModel category;
    private String categoryCode;
}
