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
public class Soldier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long soldierId;
    @Enumerated(EnumType.STRING)
    private Fraction fraction;
    @ManyToOne
    private Gamer gamer;
    private double positionX;
    private double positionY;
}
