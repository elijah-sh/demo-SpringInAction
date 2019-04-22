/**
 * 文件名: SpittleRepositoryImpl.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.web.spittr.data.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.web.spittr.Spitter;
import com.web.spittr.Spittle;
import com.web.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-02-28 12:10
 */
@Repository
public class JdbcSpitterRepository implements SpittleRepository {


    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Spitter> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(Long spittleId) {
        jdbcTemplate.queryForList("");
        return new Spittle("Spittle " + spittleId, new Date());
    }

    @Override
    public void save(Spittle spittle) {

    }

    @Override
    public List<Spitter> findAllSpitters() {
        return this.jdbcTemplate.query( "select first_name, last_name from spitter", new SpitterMapper());
    }

    private static final class SpitterMapper implements RowMapper<Spitter> {
        @Override
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            Spitter spitter = new Spitter();
            spitter.setFirstName(rs.getString("first_name"));
            spitter.setLastName(rs.getString("last_name"));
            return spitter;
        }
    }

    public Spitter save(Spitter spitter) {
        jdbcTemplate.update(
                "insert into Spitter (username, password, first_name, last_name, email)" +
                        " values (?, ?, ?, ?, ?)",
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail());
        return spitter;
    }

    public Spitter findByUsername(String username) {
        return jdbcTemplate.queryForObject(
                "select id, username, null, first_name, last_name, email from Spitter where username=?",
                new SpitterRowMapper(),
                username);
    }

    @Override
    public List<Spittle> findRecentSpittles() {
        return null;
    }

    private static class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    null,
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"));
        }
    }
}
