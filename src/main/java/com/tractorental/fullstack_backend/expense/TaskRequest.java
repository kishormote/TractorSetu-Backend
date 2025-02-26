package com.tractorental.fullstack_backend.expense;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest
{
    private long id;
    private String taskName;
    private double price;
}
