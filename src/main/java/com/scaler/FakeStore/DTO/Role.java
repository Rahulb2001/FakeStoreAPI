package com.scaler.FakeStore.DTO;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


public class Role  {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
