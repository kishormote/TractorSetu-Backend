package com.tractorental.fullstack_backend.expense;

import java.time.LocalDate;

public interface FarmersDueResponse
{
    long getId();
    String getName();
    double getAmountDue();
    LocalDate getLastWorkDate();
}
