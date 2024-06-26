package com.example.eventhandler.handler;

import com.example.common.domain.model.Account;
import com.example.common.events.AccountCreateEvent;
import com.example.eventhandler.service.account.AccountService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("ACCOUNT_CREATE")//bean name is the same within enum EventType
@RequiredArgsConstructor
public class AccountCreateEventHandler implements EventHandler {
    private final Gson gson;
    private final AccountService accountService;

    @Override
    @Transactional
    public void handle(JsonObject object, Acknowledgment acknowledgment) {
        AccountCreateEvent event = gson.fromJson(object, AccountCreateEvent.class);
        Account account = gson.fromJson(
                (String) event.getPayload(),
                Account.class
        );
        accountService.create(account);
        acknowledgment.acknowledge();
    }
}
