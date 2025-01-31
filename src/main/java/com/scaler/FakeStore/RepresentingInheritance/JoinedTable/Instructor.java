package com.scaler.FakeStore.RepresentingInheritance.JoinedTable;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "JoinedInstructor")
@PrimaryKeyJoinColumn(name = "UserId")
public class Instructor extends User {
    private String Specialization;
}
