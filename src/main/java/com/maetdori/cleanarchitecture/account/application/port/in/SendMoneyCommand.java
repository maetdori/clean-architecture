package com.maetdori.cleanarchitecture.account.application.port.in;

import com.maetdori.cleanarchitecture.account.domain.Account;
import com.maetdori.cleanarchitecture.account.domain.Money;
import com.maetdori.cleanarchitecture.common.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

    @NonNull
    Account.AccountId sourceAccountId;

    @NonNull
    Account.AccountId targetAccountId;

    @NonNull
    Money money;

    public SendMoneyCommand(
            Account.@NonNull AccountId sourceAccountId,
            Account.@NonNull AccountId targetAccountId,
            @NonNull Money money
    ) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        this.validateSelf()
;    }
}
