package com.tinapplication.smartphonewars.jpareposotories;

import com.tinapplication.smartphonewars.entities.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface SoldierRepository extends JpaRepository<Soldier, Long> {
    @Query(value = "SELECT * FROM soldier WHERE soldier_id = :id", nativeQuery = true)
    Soldier getSoldierById(@Param("id") long id);

    @Query(value = "SELECT * FROM soldier WHERE soldier_gamer_id = :gamerid", nativeQuery = true)
    Soldier getSoldierByGamerId(@Param("gamerid") long gamerid);

    @Transactional
    @Modifying
    @Query(value = "UPDATE soldier SET position_x = :x, position_y = :y WHERE soldier_id = :id", nativeQuery = true)
    void updateSoldier(@Param("id") long id, @Param("x") double x, @Param("y") double y);
}
