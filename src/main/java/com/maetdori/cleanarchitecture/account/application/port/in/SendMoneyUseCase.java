package com.maetdori.cleanarchitecture.account.application.port.in;

public interface SendMoneyUseCase {

    boolean sendMoney(SendMoneyCommand command);
}
