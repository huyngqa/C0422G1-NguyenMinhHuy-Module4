package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(columnDefinition = "text")
    private String content;
    private String summary;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String title, String author, LocalDateTime creationTime, String content, String summary, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.creationTime = creationTime;
        this.content = content;
        this.summary = summary;
        this.category = category;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCreationTime() {
        this.creationTime = LocalDateTime.now();
    }

}
