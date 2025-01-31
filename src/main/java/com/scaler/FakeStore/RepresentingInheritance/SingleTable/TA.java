package com.scaler.FakeStore.RepresentingInheritance.SingleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "1")
public class TA extends User {

    private Integer numberOfSessions;
    private Double avgRating;

}
