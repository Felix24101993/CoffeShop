package com.endava.mentorship2022.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100, unique = true)
    private String alias;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    public Category(long id) {
        this.id = id;
    }
}
