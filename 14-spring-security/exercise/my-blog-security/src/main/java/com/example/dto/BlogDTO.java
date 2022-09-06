package com.example.dto;

import javax.validation.constraints.NotBlank;

public class BlogDTO {
    @NotBlank(message = "không được trống")
    private String title;
    @NotBlank(message = "không được trống")
    private String author;
    //    private LocalDateTime creationTime;
    @NotBlank(message = "không được trống")
    private String content;
    private String summary;
    private String category;

    public BlogDTO() {
    }

    public BlogDTO(String title, String author, String content, String summary, String category) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.summary = summary;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
