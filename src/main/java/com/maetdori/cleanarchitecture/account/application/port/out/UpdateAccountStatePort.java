package com.maetdori.cleanarchitecture.account.application.port.out;

import com.maetdori.cleanarchitecture.account.domain.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);
}
