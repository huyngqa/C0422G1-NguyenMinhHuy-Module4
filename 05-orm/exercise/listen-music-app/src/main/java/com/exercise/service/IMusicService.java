package com.exercise.service;

import com.exercise.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    void update( Music music);

    void remove(int id);
}
