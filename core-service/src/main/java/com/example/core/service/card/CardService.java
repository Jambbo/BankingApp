package com.example.core.service.card;

import com.example.common.domain.model.Card;
import com.example.core.service.CommandService;
import com.example.core.service.QueryService;

import java.util.UUID;

public interface CardService
        extends QueryService<Card>, CommandService<Card> {


    void createByClientId(UUID id);

    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);
}
