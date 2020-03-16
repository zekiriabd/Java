package com.example.myapplication.model;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Baby {

    private int id;
    private String firstName;
    private String lastName;
}
