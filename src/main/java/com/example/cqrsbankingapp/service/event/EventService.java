package com.example.cqrsbankingapp.service.event;

import com.example.cqrsbankingapp.domain.model.Account;
import com.example.cqrsbankingapp.events.AbstractEvent;
import com.example.cqrsbankingapp.events.Event;
import com.example.cqrsbankingapp.service.CommandService;
import com.example.cqrsbankingapp.service.QueryService;

public interface EventService {

    void create(AbstractEvent event);

}
