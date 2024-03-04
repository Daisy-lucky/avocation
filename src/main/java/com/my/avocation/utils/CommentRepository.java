package com.my.avocation.utils;

import com.my.avocation.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    //添加评论
    Comment save(Comment comment);

//    // 查询某个博客下的所有评论
//    @Query("select * from Comment c where c.wordId = ?1")
//     List<Comment> findByBlogId(Long blogId);
}
