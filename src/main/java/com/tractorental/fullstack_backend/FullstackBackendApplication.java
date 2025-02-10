package com.tractorental.fullstack_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullstackBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullstackBackendApplication.class, args);
    }

    public int  add(int a, int b)
    {
        return a+b;
    }

}
