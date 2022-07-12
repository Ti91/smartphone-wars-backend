package com.tinapplication.smartphonewars.services;

import com.tinapplication.smartphonewars.entities.Gamer;
import com.tinapplication.smartphonewars.security.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final GamerService gamerService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Gamer gamer = gamerService.getGamerByName(s);
        return new UserData(gamer);
    }
}
