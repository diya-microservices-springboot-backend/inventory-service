package com.diya.microservices.inventory.utils;

public class EndPoints {
    public static final String INVENTORY = "/inventory";
    public static final String ADD_INVENTORY = "/add";
    public static final String GET_INVENTORY_BY_SKU_CODE = "/get/{skuCode}";
    public static final String GET_INVENTORY_BY_QUANTITY = "/get/quantity/{quantity}";
    public static final String GET_ALL_INVENTORY = "/get/all";
    public static final String UPDATE_INVENTORY = "/update/{id}/{quantity}";
    public static final String IS_IN_STOCK = "/isInStock";
}
