package com.example.cqrsbankingapp.service.transaction;

import com.example.cqrsbankingapp.domain.model.Client;
import com.example.cqrsbankingapp.domain.model.Transaction;
import com.example.cqrsbankingapp.service.client.ClientCommandService;
import com.example.cqrsbankingapp.service.client.ClientQueryService;
import com.example.cqrsbankingapp.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionCommandService commandService;
    private final TransactionQueryService queryService;

    @Override
    public void create(Transaction object) {
        commandService.create(object);
    }

    @Override
    public Transaction getById(UUID id) {
        return queryService.getById(id);
    }
}
