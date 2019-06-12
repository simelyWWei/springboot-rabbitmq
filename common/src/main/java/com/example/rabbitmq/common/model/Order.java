package com.example.rabbitmq.common.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private String id;

    private String name;

    private String messageId;
}
