package com.exercise.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private int id;

    private String name;

    private String singer;

    private String type;

    private String link;

    private MultipartFile music;

    public MusicForm() {
    }

    public MusicForm(int id, String name, String singer, String type, String link, MultipartFile music) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.link = link;
        this.music = music;
    }

    public MusicForm(int id, String name, String singer, String type, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.link = link;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public MultipartFile getMusic() {
        return music;
    }

    public void setMusic(MultipartFile music) {
        this.music = music;
    }
}
