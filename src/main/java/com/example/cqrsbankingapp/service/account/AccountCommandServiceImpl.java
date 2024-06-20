package com.example.cqrsbankingapp.service.account;

import com.example.cqrsbankingapp.domain.model.Account;
import com.example.cqrsbankingapp.events.AccountCreateEvent;
import com.example.cqrsbankingapp.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private EventService eventService;

    @Override
    public void create(Account object) {
        AccountCreateEvent accountCreateEvent = new AccountCreateEvent(object);
        eventService.create(accountCreateEvent);
    }
}
