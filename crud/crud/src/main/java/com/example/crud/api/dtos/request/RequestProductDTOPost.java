package com.example.crud.api.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record RequestProductDTOPost(@NotBlank String name, float price_in_cents) {
}
