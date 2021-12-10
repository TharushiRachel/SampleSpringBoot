package com.example.SampleSpringBoot.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class ProductUpdateRequest {

    private String name;

    private String price;

    private int quantity;

    private Date startDate;

    private Date closeDate;
}
