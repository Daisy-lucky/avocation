package com.my.avocation.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "label")
public class Label {

    @Id
    private int id;


    private String description;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
