package com.example.pricecomparison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")

public class GoodsController {
    @Autowired
    private GoodsService goodsService;




}
