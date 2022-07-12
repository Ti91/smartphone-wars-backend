package com.tinapplication.smartphonewars.entities;

public enum Role {
    ADMIN("Admin"),
    GAMER("Gamer");

    private String role;

    Role(String value) {
        this.role = value;
    }
}
