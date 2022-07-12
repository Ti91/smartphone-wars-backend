package com.tinapplication.smartphonewars.rest;

import com.tinapplication.smartphonewars.entities.Soldier;
import com.tinapplication.smartphonewars.interfaces.SoldierResource;
import com.tinapplication.smartphonewars.services.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SoldierResourceImpl implements SoldierResource {
    private final SoldierService soldierService;

    @Override
    public ResponseEntity<Soldier> getSoldierById(long id) {
        return ResponseEntity.ok(soldierService.getSoldierById(id));
    }

    @Override
    public ResponseEntity<Soldier> updateSoldierById(long id, Soldier soldier) {
        return ResponseEntity.ok(soldierService.updateSoldier(soldier));
    }

    @Override
    public void deleteSoldierById(long id) {
        soldierService.deleteSoldier(id);
    }
}
