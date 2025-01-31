package com.scaler.FakeStore.RepresentingInheritance.JoinedTable;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
//@MappedSuperclass
@Entity(name = "JoinedUser")
public class User {

    @Id
    private Long Id;
    private String name;
    private String email;
    private String Password;

}
