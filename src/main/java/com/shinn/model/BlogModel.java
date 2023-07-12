package com.shinn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogModel extends AbstractModel{
    private String title;
    private String thumbnail;
    private String content;
    private UserModel user;
    private BlogStatusModel blogStatus;
    private int amountComment;
    private List<CommentModel> comments;
}
