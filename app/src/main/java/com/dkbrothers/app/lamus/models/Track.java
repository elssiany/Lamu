package com.dkbrothers.app.lamus.models;

import java.sql.Blob;

/**
 * Created by kens on 1/11/17.
 */

public class Track {


    private int id;
    private String title;
    private String description;
    private String category;
    private String autor;


    public Track() {

    }

    public Track(int id, String title, String description, String category, String autor) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
