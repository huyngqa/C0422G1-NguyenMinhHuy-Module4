package com.exercise.repository.impl;

import com.exercise.model.Music;
import com.exercise.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    @Override
    public List<Music> findAll() {
        TypedQuery<Music> typedQuery = BaseRepository.entityManager.
                createQuery("select m from Music m", Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Music music) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(music);
        transaction.commit();
    }

    @Override
    public Music findById(int id) {
        return BaseRepository.entityManager.find(Music.class, id);
    }

    @Override
    public void update(Music music) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(music);
        transaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        transaction.commit();
    }
}
