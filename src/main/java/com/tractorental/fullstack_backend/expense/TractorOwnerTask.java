package com.tractorental.fullstack_backend.expense;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tractorental.fullstack_backend.auth.User;

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

@Entity
@Table(name = "TRACTOR_OWNER_TASKS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TractorOwnerTask
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "TRACTOR_OWNER_ID", referencedColumnName = "ID")
    @JsonIgnore
    private User tractorOwner;

    @Column(name = "TASK_NAME")
    private String taskName;

    @Column(name = "PRICE")
    private Double price;
}
