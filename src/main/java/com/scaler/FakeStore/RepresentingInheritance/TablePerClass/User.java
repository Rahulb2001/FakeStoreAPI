package com.scaler.FakeStore.RepresentingInheritance.TablePerClass;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "TablePerClass_User")
public class User {

    @Id
    private Long Id;
    private String name;
    private String email;
    private String Password;

}
