package com.exercise.repository;

import com.exercise.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    void update( Music music);

    void remove(int id);
}
