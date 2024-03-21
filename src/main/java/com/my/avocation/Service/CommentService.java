package com.my.avocation.Service;


import com.my.avocation.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class CommentService {



    public void addComment(){
        Comment comment = new Comment();
        comment.setContent("test");
        comment.setRootCommentId(0);
        comment.setCreateTime(new Date(System.currentTimeMillis()));


        //cr.save(new Comment(comment));
    }
}
