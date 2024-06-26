package com.example.core.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class TransactionDto {

    @NotNull(
            message = "id must be not null.",
            groups = OnUpdate.class
    )
    @Null(
            message = "id must be null.",
            groups = OnCreate.class
    )
    UUID id;

    @NotNull(
            message = "Card sender must be not null.",
            groups = OnCreate.class
    )
    @Null(
            message = "Card sender must be null."
    )
    @Valid
    private CardDto from;

    @NotNull(
            message = "Card receiver must be not null.",
            groups = OnCreate.class
    )
    @Null(
            message = "Card receiver must be null."
    )
    @Valid
    private CardDto to;

    @NotNull(
            message = "Amount must be not null."
    )
    @Positive(
            message = "Amount must be positive."
    )
    private BigDecimal amount;

}
