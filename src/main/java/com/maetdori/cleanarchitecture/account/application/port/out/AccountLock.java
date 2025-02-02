package com.maetdori.cleanarchitecture.account.application.port.out;

import com.maetdori.cleanarchitecture.account.domain.Account;

public interface AccountLock {

    void lockAccount(Account.AccountId accountId);

    void releaseAccount(Account.AccountId accountId);
}
