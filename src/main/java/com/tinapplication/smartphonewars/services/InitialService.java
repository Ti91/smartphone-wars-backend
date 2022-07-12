package com.tinapplication.smartphonewars.services;

import com.tinapplication.smartphonewars.entities.Gamer;
import com.tinapplication.smartphonewars.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class InitialService {
    private final GamerService gamerService;

    @PostConstruct
    public void init() {
        Gamer admin = gamerService.getGamerByName("admin");
        if (admin == null) {
            gamerService.addGamer("admin", "admin", Role.ADMIN);
        }
    }
}
