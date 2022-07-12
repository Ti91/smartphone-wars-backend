package com.tinapplication.smartphonewars.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Gamer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gamerId;
    @Column(unique = true)
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
