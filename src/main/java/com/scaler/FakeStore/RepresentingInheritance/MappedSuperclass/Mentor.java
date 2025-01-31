package com.scaler.FakeStore.RepresentingInheritance.MappedSuperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "MappedMentor")

public class Mentor extends User {

    private String mentorRating;
}
