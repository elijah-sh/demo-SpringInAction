/**
 * 文件名: JpaSpitterRepository.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.web.spittr.data.impl;

import com.web.spittr.Spitter;
import com.web.spittr.Spittle;
import com.web.spittr.data.SpittleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * @description:
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-05-06 10:56
 */
@Repository
public class JpaSpitterRepository implements SpittleRepository {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public List<Spitter> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(Long spittleId) {
        return null;
    }

    @Override
    public void save(Spitter spitter) {
        emf.createEntityManager().persist(spitter);
    }

    @Override
    public void addSpitter(Spitter spitter) {

    }

    @Override
    public void update(Spitter spitter) {

    }

    @Override
    public List<Spitter> findByUsername(String username) {
        return (List<Spitter>) emf.createEntityManager().find(Spitter.class, username);
    }

    @Override
    public List<Spittle> findRecentSpittles() {
        return null;
    }

    @Override
    public List<Spitter> findAllSpitters() {
        return null;
    }

    @Override
    public Spitter findById(Long id) {
        return emf.createEntityManager().find(Spitter.class, id);
    }

    @Override
    public int[] batchUpdate(List<Spitter> spitters) {
        return new int[0];
    }
}
