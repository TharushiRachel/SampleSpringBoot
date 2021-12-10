package com.example.SampleSpringBoot.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class ProductViewResponse {

    private String id;

    private String name;

    private String price;

    private int quantity;

    private Date startDate;

    private Date closeDate;
}
