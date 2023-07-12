package com.shinn.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentModel extends AbstractModel{
    private String content;
    private BlogModel blogModel;
    private UserModel userModel;
}
