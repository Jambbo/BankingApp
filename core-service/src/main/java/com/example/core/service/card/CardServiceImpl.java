package com.example.core.service.card;

import com.example.common.domain.model.Card;
import com.example.common.domain.model.Client;
import com.example.core.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{
    private final CardQueryService queryService;
    private final CardCommandService commandService;
    private final ClientService clientService;
    @Override
    public void create(Card object) {
        commandService.create(object);
    }

    @Override
    public void createByClientId(UUID clientId) {
        Client client = clientService.getById(clientId);
        Card card = new Card(client.getAccount());
        commandService.create(card);
    }

    @Override
    public Card getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public boolean existsByNumberAndDate(String number, String date) {
        return queryService.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(String number, String date, String cvv) {
            return queryService.getByNumberAndDateAndCvv(number,date,cvv);
    }
}
