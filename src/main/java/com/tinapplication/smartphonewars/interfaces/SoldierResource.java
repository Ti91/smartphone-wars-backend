package com.tinapplication.smartphonewars.interfaces;

import com.tinapplication.smartphonewars.entities.Soldier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("soldier")
public interface SoldierResource {
    @GetMapping("{id}")
    ResponseEntity<Soldier> getSoldierById(@PathVariable("id") long id);

    @PutMapping("{id}")
    ResponseEntity<Soldier> updateSoldierById(@PathVariable("id") long id,
                                              @RequestBody Soldier soldier);

    @DeleteMapping("{id}")
    void deleteSoldierById(@PathVariable("id") long id);
}
