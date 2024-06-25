package com.example.cqrsbankingapp.web.controller;

import com.example.cqrsbankingapp.domain.model.Card;
import com.example.cqrsbankingapp.domain.model.Client;
import com.example.cqrsbankingapp.domain.model.Transaction;
import com.example.cqrsbankingapp.service.card.CardService;
import com.example.cqrsbankingapp.web.dto.CardDto;
import com.example.cqrsbankingapp.web.dto.TransactionDto;
import com.example.cqrsbankingapp.web.dto.mapper.CardMapper;
import com.example.cqrsbankingapp.web.dto.mapper.TransactionMapper;
import com.example.cqrsbankingapp.web.security.SecurityUser;
import com.example.cqrsbankingapp.web.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final SecurityService securityService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create(){
        SecurityUser user = securityService.getUserFromRequest();
        UUID id = user.getId();
        cardService.createByClientId(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public CardDto getById(
            @PathVariable final UUID id
    ){
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    @PreAuthorize("@ssi.canAccessTransaction(#id)")
    public List<TransactionDto> getTransactionsById(
            @PathVariable final UUID id
    ){
        Card card = cardService.getById(id);
        List<Transaction> transactions = card.getTransactions();
        return transactionMapper.toDto(transactions);
    }

}
