package com.example.cqrsbankingapp.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class AccountDto {
    @NotNull(
            message = "id must be not null.",
            groups = OnUpdate.class
    )
    @Null(
            message = "id must be null.",
            groups = OnCreate.class
    )
    private UUID id;
    //That means that we do not receive this field from user, we update them on
    // server and that's why we only return this to user
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String number;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal balance;

}
