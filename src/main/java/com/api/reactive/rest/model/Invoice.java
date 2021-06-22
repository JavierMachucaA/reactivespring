package com.api.reactive.rest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Invoice {

    @Id
    private String id;
    private String name;
    private String number;
    private Double amount;
}
