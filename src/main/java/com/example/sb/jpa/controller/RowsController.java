package com.example.sb.jpa.controller;

import com.example.sb.jpa.model.Row;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rows")
public class RowsController {
    @GetMapping
    public List<Row> getRows() {
        List<Row> l = new ArrayList<>();
        l.add(Row.builder().data("one").build());
        return l;
    }
}
