package com.tractorental.fullstack_backend.expense;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkLogRequest
{
    private Long farmerId;
    private String farmerName;
    private Long tractorOwnerTaskId;
    private LocalDate taskDate;
    private Double area;
    private Double amountPaid;
}

