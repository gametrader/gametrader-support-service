package com.gametrader.gametradersupportservice.controller;

import com.gametrader.gametradersupportservice.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/support/category")
public class CategoryController {

    @GetMapping("/get/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(Arrays.stream(Category.values()).collect(Collectors.toList()), HttpStatus.OK);
    }
}
