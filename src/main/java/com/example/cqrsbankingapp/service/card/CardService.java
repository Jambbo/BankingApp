package com.example.cqrsbankingapp.service.card;

import com.example.cqrsbankingapp.domain.model.Account;
import com.example.cqrsbankingapp.domain.model.Card;
import com.example.cqrsbankingapp.service.CommandService;
import com.example.cqrsbankingapp.service.QueryService;

import java.util.UUID;

public interface CardService
extends QueryService<Card>, CommandService<Card> {


    void createByClientId(UUID id);

    boolean existsByNumberAndDate(String number, String date);
}
