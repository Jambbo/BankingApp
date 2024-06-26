package com.example.core.service.client;

import com.example.common.domain.model.Client;
import com.example.core.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {
    boolean existsByUsername(String username);

    Client getByUsername(String username);
}
