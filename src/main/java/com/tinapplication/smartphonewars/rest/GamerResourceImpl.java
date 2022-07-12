package com.tinapplication.smartphonewars.rest;

import com.tinapplication.smartphonewars.entities.Gamer;
import com.tinapplication.smartphonewars.entities.Role;
import com.tinapplication.smartphonewars.entities.Soldier;
import com.tinapplication.smartphonewars.interfaces.GamerResource;
import com.tinapplication.smartphonewars.services.GamerService;
import com.tinapplication.smartphonewars.services.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GamerResourceImpl implements GamerResource {
    private final GamerService gamerService;
    private final SoldierService soldierService;

    @Override
    public ResponseEntity<Soldier> addGamer(Gamer gamer) {
        gamer = gamerService.addGamer(gamer.getName(), gamer.getPassword(), Role.GAMER);
        return ResponseEntity.ok(soldierService.addSoldier(gamer));
    }

    @Override
    public ResponseEntity<Gamer> getGamerById(long id) {
        return ResponseEntity.ok(gamerService.getGamerById(id));
    }

    @Override
    public ResponseEntity<Gamer> getGamerByName(String name) {
        return ResponseEntity.ok(gamerService.getGamerByName(name));
    }

    @Override
    public void deleteGamerById(long id) {
        gamerService.deleteGamerById(id);
    }
}
