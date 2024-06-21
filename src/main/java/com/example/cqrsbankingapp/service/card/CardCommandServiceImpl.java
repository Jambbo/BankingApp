package com.example.cqrsbankingapp.service.card;

import com.example.cqrsbankingapp.domain.model.Card;
import com.example.cqrsbankingapp.events.CardCreateEvent;
import com.example.cqrsbankingapp.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardCommandServiceImpl implements CardCommandService{
    private final EventService eventService;
    @Override
    public void create(Card object) {
        CardCreateEvent cardCreateEvent = new CardCreateEvent(object);
        eventService.create(cardCreateEvent);
    }
}
