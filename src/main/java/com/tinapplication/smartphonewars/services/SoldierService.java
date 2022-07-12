package com.tinapplication.smartphonewars.services;

import com.tinapplication.smartphonewars.entities.Fraction;
import com.tinapplication.smartphonewars.entities.Gamer;
import com.tinapplication.smartphonewars.entities.Soldier;
import com.tinapplication.smartphonewars.jpareposotories.SoldierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class SoldierService {
    private final SoldierRepository soldierRepository;

    public Soldier addSoldier(Gamer gamer) {
        Random random = new Random();
        boolean rand = random.nextBoolean();
        Soldier soldier = Soldier.builder()
                .gamer(gamer)
                .build();
        if (rand) {
            soldier.setFraction(Fraction.IMPERIUM);
            soldier.setPositionX(0);
            soldier.setPositionY(0);
        }else {
            soldier.setFraction(Fraction.REBELLEN);
            soldier.setPositionX(100);
            soldier.setPositionY(100);
        }
        return soldierRepository.save(soldier);
    }

    public Soldier getSoldierById(long id) {
        return soldierRepository.getSoldierById(id);
    }

    public Soldier updateSoldier(Soldier soldier) {
        soldier = soldierRepository.getSoldierById(soldier.getSoldierId());
        soldier.setPositionX(soldier.getPositionX());
        soldier.setPositionY(soldier.getPositionY());
        return soldierRepository.save(soldier);
    }

    public void deleteSoldier(long id) {
        soldierRepository.deleteById(id);
    }
}
