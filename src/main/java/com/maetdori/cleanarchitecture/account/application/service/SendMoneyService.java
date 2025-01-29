package com.maetdori.cleanarchitecture.account.application.service;

import com.maetdori.cleanarchitecture.account.application.port.in.SendMoneyCommand;
import com.maetdori.cleanarchitecture.account.application.port.in.SendMoneyUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        return false;
    }
}
