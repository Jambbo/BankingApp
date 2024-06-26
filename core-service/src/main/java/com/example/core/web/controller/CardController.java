package com.example.core.web.controller;

import com.example.common.domain.model.Card;
import com.example.common.domain.model.Transaction;
import com.example.core.service.card.CardService;
import com.example.core.web.dto.CardDto;
import com.example.core.web.dto.TransactionDto;
import com.example.core.web.dto.mapper.CardMapper;
import com.example.core.web.dto.mapper.TransactionMapper;
import com.example.core.web.security.SecurityUser;
import com.example.core.web.security.service.SecurityService;
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
    public void create() {
        SecurityUser user = securityService.getUserFromRequest();
        UUID id = user.getId();
        cardService.createByClientId(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public CardDto getById(
            @PathVariable final UUID id
    ) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    @PreAuthorize("@ssi.canAccessTransaction(#id)")
    public List<TransactionDto> getTransactionsById(
            @PathVariable final UUID id
    ) {
        Card card = cardService.getById(id);
        List<Transaction> transactions = card.getTransactions();
        return transactionMapper.toDto(transactions);
    }

}
