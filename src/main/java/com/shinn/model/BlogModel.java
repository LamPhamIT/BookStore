package com.shinn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogModel extends AbstractModel{
    private String title;
    private String thumbnail;
    private String Content;
    private UserModel user;
    private BlogStatusModel blogStatus;
}
