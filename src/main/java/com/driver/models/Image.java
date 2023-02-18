package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String dimension;

    // child of image table;
    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Blog getBlog() {
        return blog;
    }

    public Image(int id, String description, String dimension, Blog blog) {
        this.id = id;
        this.description = description;
        this.dimension = dimension;
        this.blog = blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }


    public Image() {}

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
