package com.ra.entity;

public class Category {
    private int id;
    private String name;
    private String keyword;
    private String description;
    private boolean status;

    public Category() {
    }

    public Category(int id, String name, String keyword, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.keyword = keyword;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
