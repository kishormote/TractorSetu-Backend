package com.tractorental.fullstack_backend.expense;

import com.tractorental.fullstack_backend.auth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AMOUNT_DUE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AmountDue
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @ManyToOne(targetEntity = Farmers.class)
    @JoinColumn(name = "FARMER_ID", referencedColumnName = "ID")
    private Farmers farmer;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "TRACTOR_OWNER_ID", referencedColumnName = "ID")
    private User tractorOwner;

    @Column(name = "AMOUNT_DUE")
    private double amountDue;
}
