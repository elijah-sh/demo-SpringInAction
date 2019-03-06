/**
 * 文件名: SpittleRepositoryImpl.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.web.spittr.data.impl;

import com.web.spittr.Spittle;
import com.web.spittr.data.SpittleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-02-28 12:10
 */
@Service
public class SpittleRepositoryImpl implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return createSpittleList(count);
    }

    @Override
    public Spittle findOne(Long spittleId) {
        return new Spittle("Spittle " + spittleId, new Date());
    }

    @Override
    public void save(Spittle spittle) {

    }

    @Override
    public Spittle findByUsername(String username) {
        return null;
    }

    private List<Spittle> createSpittleList (int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}
