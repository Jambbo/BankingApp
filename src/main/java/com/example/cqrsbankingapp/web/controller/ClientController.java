package com.example.cqrsbankingapp.web.controller;

import com.example.cqrsbankingapp.domain.model.Client;
import com.example.cqrsbankingapp.service.client.ClientService;
import com.example.cqrsbankingapp.web.dto.AccountDto;
import com.example.cqrsbankingapp.web.dto.CardDto;
import com.example.cqrsbankingapp.web.dto.ClientDto;
import com.example.cqrsbankingapp.web.dto.mapper.AccountMapper;
import com.example.cqrsbankingapp.web.dto.mapper.CardMapper;
import com.example.cqrsbankingapp.web.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final CardMapper cardMapper;
    private final AccountMapper accountMapper;

    @GetMapping("/{id}")
    public ClientDto getById(
            @PathVariable final UUID id
            )
    {
        return clientMapper.toDto(clientService.getById(id));
    }

    @GetMapping("/{id}/cards")
    public List<CardDto> getCardsById(
            @PathVariable final UUID id
    ){
        return cardMapper.toDto(clientService.getById(id).getCards());
    }

    @GetMapping("/{id}/account")
    public AccountDto getAccountById(
            @PathVariable final UUID id
    ){
        return accountMapper.toDto(clientService.getById(id).getAccount());
    }

}