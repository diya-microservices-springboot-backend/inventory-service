package com.diya.microservices.inventory.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ResponseHandler {
    String response;
    String responseCode;
    String errorMessage;
}
