package com.example.pricecomparison.entity;

import lombok.Data;

import java.util.List;

@Data
public class Goods {
    private int id;
    private String name;
    private String url;
    private String description;
    private String price;
    private String category;
    private String image;
    private String createTime;
    private String lowestPrice;
    private List<String> priceHistory;
}
