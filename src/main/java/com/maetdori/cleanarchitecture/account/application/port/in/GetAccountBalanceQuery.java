package com.maetdori.cleanarchitecture.account.application.port.in;

import com.maetdori.cleanarchitecture.account.domain.Account;
import com.maetdori.cleanarchitecture.account.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalance(Account.AccountId accountId);
}
