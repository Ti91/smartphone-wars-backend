package com.tinapplication.smartphonewars.jpareposotories;

import com.tinapplication.smartphonewars.entities.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GamerRepository extends JpaRepository<Gamer, Long> {
    @Query(value = "SELECT * FROM gamer WHERE name = :name", nativeQuery = true)
    Gamer getGamerByName(@Param("name") String name);

    @Query(value = "SELECT * FROM gamer WHERE gamer_id = :id", nativeQuery = true)
    Gamer getGamerById(@Param("id") long id);
}
