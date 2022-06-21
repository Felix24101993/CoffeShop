package com.endava.mentorship2022.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "date", nullable = false)
    private LocalDate date = LocalDate.now();

    @Column(name = "total", nullable = false)
    private float total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 10, columnDefinition = "PENDING")
    private OrderStatus status = OrderStatus.PENDING;
}
