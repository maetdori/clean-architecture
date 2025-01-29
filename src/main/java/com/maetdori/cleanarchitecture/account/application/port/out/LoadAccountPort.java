package com.maetdori.cleanarchitecture.account.application.port.out;

import com.maetdori.cleanarchitecture.account.domain.Account;

import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(Account.AccountId accountId, LocalDateTime baselineDate);
}
