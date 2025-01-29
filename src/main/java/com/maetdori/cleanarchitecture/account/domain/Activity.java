package com.maetdori.cleanarchitecture.account.domain;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@RequiredArgsConstructor
public class Activity {

    ActivityId id;

    @NonNull
    Account.AccountId ownerAccountId;

    @NonNull
    Account.AccountId sourceAccountId;

    @NonNull
    Account.AccountId targetAccountId;

    @NonNull
    LocalDateTime timestamp;

    @NonNull
    Money money;

    public Activity(
            @NonNull Account.AccountId ownerAccountId,
            @NonNull Account.AccountId sourceAccountId,
            @NonNull Account.AccountId targetAccountId,
            @NonNull LocalDateTime timestamp,
            @NonNull Money money
    ) {
        this.id = null;
        this.ownerAccountId = ownerAccountId;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.timestamp = timestamp;
        this.money = money;
    }

    public record ActivityId(Long value) { }
}
