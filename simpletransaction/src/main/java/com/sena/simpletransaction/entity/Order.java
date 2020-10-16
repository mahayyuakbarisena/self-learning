package com.sena.simpletransaction.entity;

import com.sena.simpletransaction.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate transactionDate;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @Column(name = "sum_amount")
    private Integer sumAmount;
}
