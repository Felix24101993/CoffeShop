package com.endava.mentorship2022.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "alias", length = 200, nullable = false, unique = true)
    private String alias;

    @Column(name = "description", length = 3000, nullable = false, unique = true)
    private String description;

    @Column(name = "brand", length = 80, nullable = false)
    private String brand;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "stock", nullable = false)
    private int stock;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
