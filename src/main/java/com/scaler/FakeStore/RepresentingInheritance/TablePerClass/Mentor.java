package com.scaler.FakeStore.RepresentingInheritance.TablePerClass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "TablePerClassMentor")
public class Mentor extends User {

    private String mentorRating;
}
