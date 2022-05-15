package com.ganesh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PAYMENT_INFO")
public class PaymentInfo {

    @Id
    @GeneratedValue(generator = "UUID2")
    @GenericGenerator(name="UUID2",strategy = "org.hibernate.id.UUIDGenerator")
    private String paymentId;
    private String accountNo;
    private double totalFare;
    private String cardType;
    private Long passengerId;
}
