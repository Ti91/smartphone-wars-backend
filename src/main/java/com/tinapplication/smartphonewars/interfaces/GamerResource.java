package com.tinapplication.smartphonewars.interfaces;

import com.tinapplication.smartphonewars.entities.Gamer;
import com.tinapplication.smartphonewars.entities.Soldier;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("gamer")
public interface GamerResource {
    @PostMapping
    ResponseEntity<Soldier> addGamer(@RequestBody Gamer gamer);

    @GetMapping("{id}")
    ResponseEntity<Gamer> getGamerById(@PathVariable("id") long id);

    @GetMapping
    ResponseEntity<Gamer> getGamerByName(@Param("name") String name);

    @DeleteMapping("{id}")
    void deleteGamerById(@PathVariable("id") long id);
}
