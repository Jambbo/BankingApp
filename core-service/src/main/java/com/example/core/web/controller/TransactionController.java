package com.example.core.web.controller;

import com.example.common.domain.model.Transaction;
import com.example.core.service.card.CardService;
import com.example.core.service.transaction.TransactionService;
import com.example.core.web.dto.OnCreate;
import com.example.core.web.dto.TransactionDto;
import com.example.core.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PostMapping("/create")
    @PreAuthorize("@ssi.canAccessCard(#dto.from)")
    public void create(
            @RequestBody @Validated(OnCreate.class) final TransactionDto dto
            ){
        if(!cardService.existsByNumberAndDate(
                dto.getTo().getNumber(),
                dto.getTo().getDate()
        )){
            throw new IllegalStateException("Card doesn't exists.");
        }
        Transaction transaction = transactionMapper.toEntity(dto);
        transactionService.create(transaction);
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessTransaction(#id)")
    public TransactionDto getTransactionById(
            @PathVariable final UUID id
    ){
        return transactionMapper.toDto(transactionService.getById(id));
    }

}
