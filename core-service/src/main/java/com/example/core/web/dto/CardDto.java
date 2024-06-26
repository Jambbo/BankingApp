package com.example.core.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardDto {

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
             message = "card number must be not null",
             groups = OnCreate.class
     )
     @Null(
             message = "Card number must be null."
     )
     String number;
    @NotNull(
            message = "card date must be not null",
            groups = OnCreate.class
    )
    @Null(
            message = "Card date must be null."
    )
     String date;
    @NotNull(
            message = "card cvv must be not null",
            groups = OnCreate.class
    )
    @Null(
            message = "Card cvv must be null."
    )
     String cvv;
}
