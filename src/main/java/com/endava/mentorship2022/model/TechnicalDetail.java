package com.endava.mentorship2022.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "technical_details")
public class TechnicalDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name",nullable = false, length=250)
    private String name;

    @Column(name="value",nullable = false, length=250)
    private String value;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}

