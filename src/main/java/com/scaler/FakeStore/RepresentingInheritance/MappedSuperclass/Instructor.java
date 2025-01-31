package com.scaler.FakeStore.RepresentingInheritance.MappedSuperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "MappedInstructor")
public class Instructor extends User {
    private String Specialization;
}
