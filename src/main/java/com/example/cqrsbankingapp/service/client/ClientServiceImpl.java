package com.example.cqrsbankingapp.service.client;

import com.example.cqrsbankingapp.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
    private ClientQueryService queryService;
    private ClientCommandService commandService;
    @Override
    public void create(Client object) {
        commandService.create(object);
    }

    @Override
    public Client getById(UUID id) {
        return queryService.getById(id);
    }
}
