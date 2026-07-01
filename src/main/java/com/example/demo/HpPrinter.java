package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class HpPrinter implements Printer {

    @Value("${printer.count}")
    private int count;

    @Override
    public void print(String message) {
        count--;
        System.out.println("HP印表機: " + message);
        System.out.println("剩餘使用次數: " + count);
    }
}