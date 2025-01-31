package com.scaler.FakeStore.RepresentingInheritance.JoinedTable;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "JoinedMentor")
@PrimaryKeyJoinColumn(name = "UserId")
public class Mentor extends User {

    private String mentorRating;
}
