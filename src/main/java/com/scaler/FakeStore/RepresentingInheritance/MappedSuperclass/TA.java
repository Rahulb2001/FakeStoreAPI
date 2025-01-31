package com.scaler.FakeStore.RepresentingInheritance.MappedSuperclass;


import jakarta.persistence.Entity;

@Entity(name = "MappedTA")
public class TA extends User {

    private Integer numberOfSessions;
    private Double avgRating;

}
