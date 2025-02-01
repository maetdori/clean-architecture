package com.maetdori.cleanarchitecture.account.adapter.in.web;

import com.maetdori.cleanarchitecture.account.application.port.in.SendMoneyCommand;
import com.maetdori.cleanarchitecture.account.application.port.in.SendMoneyUseCase;
import com.maetdori.cleanarchitecture.account.domain.Account;
import com.maetdori.cleanarchitecture.account.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMoneyController {

    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Long amount) {

        SendMoneyCommand command = new SendMoneyCommand(
                new Account.AccountId(sourceAccountId),
                new Account.AccountId(targetAccountId),
                Money.of(amount));

        sendMoneyUseCase.sendMoney(command);
    }
}
