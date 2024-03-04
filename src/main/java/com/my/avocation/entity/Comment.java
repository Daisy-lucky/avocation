package com.my.avocation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "comment")
//评论的实例
public class Comment {

    @Id
    private int id;

    //评论的内容
    private String content;

    //被评论的帖子或评论的id
    private int  rootCommentId;

    //回复的评论的id
    private int toCommentId;

//    //评论的用户
//    private User userId;

    //评论的时间
    private Date createTime;

    //评论的点赞数
    private int likeCount;

    //评论的修改时间
    private Date updateTime;

    //所属文章的Id
    private int wordId;

    //是否删除
    private int isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRootCommentId() {
        return rootCommentId;
    }

    public void setRootCommentId(int rootCommentId) {
        this.rootCommentId = rootCommentId;
    }

    public int getToCommentId() {
        return toCommentId;
    }

    public void setToCommentId(int toCommentId) {
        this.toCommentId = toCommentId;
    }

//    public User getUserId() {
//        return userId;
//    }
//
//    public void setUserId(User userId) {
//        this.userId = userId;
//    }



    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
