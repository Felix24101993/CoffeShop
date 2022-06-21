package com.endava.mentorship2022.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "quantity", nullable = false)
    private short quantity;

    @Column(name = "unit_price", nullable = false)
    private float unitPrice;

    @Column(name = "subtotal")
    @Formula("unit_price * quantity")
    private float subtotal;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // TODO
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;

}