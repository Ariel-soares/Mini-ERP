package com.arielSoares.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_product")
public class Product {

    @Id
    private Long id;
    private String name;
    private String description;

}
