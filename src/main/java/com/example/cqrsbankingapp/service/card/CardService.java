package com.example.cqrsbankingapp.service.card;

import com.example.cqrsbankingapp.domain.model.Account;
import com.example.cqrsbankingapp.domain.model.Card;
import com.example.cqrsbankingapp.service.CommandService;
import com.example.cqrsbankingapp.service.QueryService;

public interface CardService
extends QueryService<Card>, CommandService<Card> {



}
