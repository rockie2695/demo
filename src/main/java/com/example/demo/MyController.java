package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MyController {

    @Autowired
    public Printer printer;

    @RequestMapping("/test")
    public String test() {
        printer.print("Hello World");
        return "Hello World";
    }

    @RequestMapping("/product")
    public Store product() {
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("橘子");
        store.setProductList(list);
        return store;
    }

    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id) {
        System.out.println("id 的值為: " + id);
        return "請求成功";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student) {
        System.out.println("student 中的 id 值為: " + student.getId());
        System.out.println("student 中的 name 值為: " + student.getName());
        return "請求成功";
    }

    @RequestMapping("/test3")
    public String test3(@RequestHeader String info) {
        System.out.println("info 的值為: " + info);
        return "請求成功";
    }

    @RequestMapping("/test4/{id}")
    public String test4(@PathVariable Integer id) {
        System.out.println("id 的值為: " + id);
        return "請求成功";
    }
}
