package com.tractorental.fullstack_backend.expense;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateRequest
{
    private List<TaskRequest> tasks;
}