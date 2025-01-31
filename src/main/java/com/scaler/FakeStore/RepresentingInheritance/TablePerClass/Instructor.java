package com.scaler.FakeStore.RepresentingInheritance.TablePerClass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "TablePerClassInstructor")
public class Instructor extends User {
    private String Specialization;
}
