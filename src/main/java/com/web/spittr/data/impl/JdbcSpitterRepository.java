/**
 * 文件名: SpittleRepositoryImpl.java
 * 版权：Copyright 2017-2022 CMCC All Rights Reserved.
 * 描述:
 */
package com.web.spittr.data.impl;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.web.spittr.Spitter;
import com.web.spittr.Spittle;
import com.web.spittr.data.SpittleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-02-28 12:10
 */
@Repository
@Slf4j
public class JdbcSpitterRepository implements SpittleRepository
{

    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, first_name, last_name, email) values (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_SPITTER = "update spitter set username = ?, password = ?, first_name = ?, last_name = ?, email = ?" +
            "where id = ?";
    private static final String SQL_INSERT_SPITTER_PARAM = "insert into spitter (username, password, first_name, last_name, email)" +
            " values (:username, :password, :first_name, :last_name, :email)";

    private static final String SQL_UPDATE_SPITTER_ROLE = "update spitter set ROLE_USER = ?, enabled = ?" +
            "where id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

   private JdbcOperations jdbcOperations;

    @Inject
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Spitter> findSpittles(long max, int count) {
        List<Spitter> spitters = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Spitter spitter = new Spitter();
            spitter.setFirstName("LEE"+i);
            spitter.setLastName("JACK");
            spitters.add(spitter);
        }
        return spitters;
    }

    @Override
    public Spittle findOne(Long spittleId) {
      //  jdbcTemplate.queryForList("");
        return new Spittle("Spittle " + spittleId, new Date());
    }

    @Override
    public void save(Spitter spitter) {
        jdbcOperations.update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail());
    }

    public void addSpitter(Spitter spitter) {
        // 绑定参数
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", spitter.getUsername());
        paramMap.put("password", spitter.getPassword());
        paramMap.put("first_name", spitter.getFirstName());
        paramMap.put("last_name", spitter.getLastName());
        paramMap.put("email", spitter.getEmail());
      //  jdbcOperations.update(SQL_INSERT_SPITTER_PARAM, paramMap);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps  = (PreparedStatement) connection.prepareStatement(SQL_INSERT_SPITTER, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, spitter.getUsername());
                ps.setObject(2, spitter.getPassword());
                ps.setObject(3, spitter.getFirstName());
                ps.setObject(4, spitter.getLastName());
                ps.setObject(5, spitter.getEmail());
                return ps;
            }
        }, keyHolder);

        paramMap.put("role_name", "ROLE_USER");
        paramMap.put("enabled", "true");
        jdbcOperations.update(SQL_UPDATE_SPITTER_ROLE, "ROLE_USER", "true", keyHolder.getKey().intValue());
    }
    @Override
    public void update(Spitter spitter) {
        jdbcOperations.update(SQL_UPDATE_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail(),
                spitter.getId()
                );
    }
    @Override
    public List<Spitter> findAllSpitters() {
        // this.jdbcTemplate.query( "select first_name, last_name from spitter", new SpitterMapper());
        return null;
    }

    private static final class SpitterMapper implements RowMapper<Spitter> {
        @Override
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            Spitter spitter = new Spitter();
            spitter.setId(rs.getLong("id"));
            spitter.setFirstName(rs.getString("first_name"));
            spitter.setLastName(rs.getString("last_name"));
            spitter.setPassword(rs.getString("password"));
            spitter.setUsername(rs.getString("username"));
            spitter.setEmail(rs.getString("email"));
            return spitter;
        }
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
                    rs.getString("password"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email")
            );
        }
    }

    public List<Spitter> findByUsername(String username) {

        List<Spitter> spitters = this.jdbcTemplate.query(
                "select id, username,password,first_name, last_name, email from spitter where username=? ",
                (rs, rowNum) -> {return new Spitter(rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"));
                },
                username);
        return spitters;
    }



    public Spitter findById(Long id) {
      Map<String, Object> rs =  jdbcOperations.queryForMap("select id, username,password,first_name, last_name, email from spitter where id=?", id);
        System.out.println((Long) rs.get("id"));
        System.out.println((String) rs.get("username"));
        System.out.println((String) rs.get("password"));
        Spitter spitter = new Spitter();
        spitter.setId((Long) rs.get("id"));
        spitter.setUsername((String) rs.get("username"));
        spitter.setPassword((String) rs.get("password"));
        spitter.setFirstName((String) rs.get("first_name"));
        spitter.setLastName((String) rs.get("last_name"));
        spitter.setEmail((String) rs.get("email"));


        return spitter;


      //log.info(o.toString());
      //  System.out.println(o);
      //  return jdbcTemplate.queryForObject(
      //                   "select id, username,password,first_name, last_name, email from spitter where id=? ",
      //                   new SpitterRowMapper(),
      //          id);
    }

    public int[] batchUpdate(final List<Spitter> spitters) {
        List<Object[]> batch = new ArrayList<Object[]>();
        for (Spitter spitter : spitters) {
            Object[] values = new Object[] {
                    spitter.getUsername(),
                    spitter.getPassword(),
                    spitter.getFirstName(),
                    spitter.getLastName(),
                    spitter.getEmail()};
            batch.add(values);
        }
        String SQL_INSERT_SPITTER = "insert into spitter (username, password, first_name, last_name, email) values (?, ?, ?, ?, ?)";

        int[] updateCounts = jdbcTemplate.batchUpdate(
                SQL_INSERT_SPITTER,
                batch);
        return updateCounts;
    }


}
