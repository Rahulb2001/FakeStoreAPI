package com.scaler.FakeStore.RepresentingInheritance.JoinedTable;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JoinedTA")
@PrimaryKeyJoinColumn(name = "UserId")
public class TA extends User {

    private Integer numberOfSessions;
    private Double avgRating;

}
