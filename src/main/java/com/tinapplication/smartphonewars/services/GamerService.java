package com.tinapplication.smartphonewars.services;

import com.tinapplication.smartphonewars.entities.Gamer;
import com.tinapplication.smartphonewars.entities.Role;
import com.tinapplication.smartphonewars.jpareposotories.GamerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamerService {
    private final GamerRepository gamerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Gamer getGamerByName(String name) {
        return gamerRepository.getGamerByName(name);
    }

    public Gamer getGamerById(long id) {
        return gamerRepository.getGamerById(id);
    }

    public Gamer addGamer(String name, String password, Role role) {
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        Gamer gamer = Gamer.builder()
                .name(name)
                .password(encodedPassword)
                .role(role)
                .build();
        return gamerRepository.save(gamer);
    }

    public void deleteGamerById(long id) {
        gamerRepository.deleteById(id);
    }
}
