package com.example.core.service.client;

import com.example.common.domain.exception.ResourceNotFoundException;
import com.example.common.domain.model.Client;
import com.example.common.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService{
    private final ClientRepository repository;
    @Override
    public Client getById(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Client getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
