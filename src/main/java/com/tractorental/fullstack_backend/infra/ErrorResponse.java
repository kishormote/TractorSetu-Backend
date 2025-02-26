package com.tractorental.fullstack_backend.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse
{
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;
}
