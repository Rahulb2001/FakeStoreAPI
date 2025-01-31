package com.scaler.FakeStore.RepresentingInheritance.SingleTable;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "user_type",
    discriminatorType = DiscriminatorType.INTEGER
)
@Entity(name = "ST_User")
@DiscriminatorValue(value = "0")
public class User {

    @Id
    private Long Id;
    private String name;
    private String email;
    private String Password;

}
