package com.softweb;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name="Id", nullable = false, unique = true)
    private int id;

    @Column(name="Firstname")
    private String firstName;

    @Column(name="Lastname")
    private  String lastName;
}
