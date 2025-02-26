package com.tractorental.fullstack_backend.expense;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "WORK_LOGS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkLogs
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(targetEntity = Farmers.class)
    @JoinColumn(name = "FARMER_ID", referencedColumnName = "ID")
    private Farmers farmer;

    @ManyToOne(targetEntity = TractorOwnerTask.class)
    @JoinColumn(name = "TRACTOR_OWNER_TASK_ID", referencedColumnName = "ID")
    private TractorOwnerTask tractorOwnerTask;

    @Column(name = "TASK_DATE")
    private LocalDate taskDate;

    @Column(name = "AMOUNT_PAID")
    private Double amountPaid;
}

