package com.example.core.service.account;

import com.example.common.domain.model.Account;
import com.example.common.events.AccountCreateEvent;
import com.example.core.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private final EventService eventService;

    @Override
    public void create(Account object) {
        AccountCreateEvent accountCreateEvent = new AccountCreateEvent(object);
        eventService.create(accountCreateEvent);
    }
}
