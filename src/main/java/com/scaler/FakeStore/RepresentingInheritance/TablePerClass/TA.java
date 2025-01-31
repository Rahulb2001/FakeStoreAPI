package com.scaler.FakeStore.RepresentingInheritance.TablePerClass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TablePerClass_TA")
public class TA extends User {

    private Integer numberOfSessions;
    private Double avgRating;

}
