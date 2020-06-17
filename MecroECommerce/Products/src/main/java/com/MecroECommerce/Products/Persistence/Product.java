package com.MecroECommerce.Products.Persistence;

import javax.persistence.*;
import lombok.*;
import java.io.Serializable;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name="Id", nullable = false, unique = true)
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Price")
    private  double price;
}