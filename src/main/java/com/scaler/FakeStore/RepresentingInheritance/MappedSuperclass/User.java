package com.scaler.FakeStore.RepresentingInheritance.MappedSuperclass;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public class User {

    @Id
    private Long Id;
    private String name;
    private String email;
    private String Password;

}
