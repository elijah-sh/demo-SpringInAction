package com.web.spittr.data;

import com.web.spittr.Spitter;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpitterRepositoy extends JpaRepository<Spitter, Long> {

    Spitter findByUsername(String username);

    List<Spitter> readSpittersByFirstNameOrLastNameOrderByLastNameAsc(String firstName, String lastName);

    List<Spitter> readSpittersByFirstNameOrderByFirstNameAscLastNameDesc(String firstName, String lastName);

    @Query("select s from spitter s where email like '%gmail.com'")
    List<Spitter> findAllByGEmail();
}
