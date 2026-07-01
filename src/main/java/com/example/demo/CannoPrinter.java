package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class CannoPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("Canno印表機: " + message);
    }
}
