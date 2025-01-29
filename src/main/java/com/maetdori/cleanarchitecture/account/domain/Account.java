package com.maetdori.cleanarchitecture.account.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Account 엔티티는 실제 계좌의 현재 스냅샷을 제공한다. 계좌에 대한 모든 입금과 출금은 Activity 엔티티에 포착된다.
 * 한 계좌에 대한 모든 활동(activity)들을 항상 메모리에 한꺼번에 올리는 것은 현명한 방법이 아니기 때문에
 * Account 엔티티는 ActivityWindow 값 객체(value object)에서 포착한 지난 며칠 혹은 몇 주 간의 범위에 해당하는 활동만 보유한다.
 * Account 엔티티는 활동창(activity window)의 첫 번째 활동 바로 전의 잔고를 표현하는 baselineBalance 속성을 가지고 있다.
 * 현재 잔고는 기준 잔고(baselineBalance)에 활동창의 모든 활동들의 잔고를 합한 값이 된다.
 * 이 모델 덕분에 계좌에서 일어나는 입금과 출금은 각각 withdraw()와 deposit() 메서드에서처럼 새로운 활동을 활동창에 추가하는 것에 불과하다.
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    private AccountId id;
    private Money baselineBalance;
    private ActivityWindow activityWindow;

    public static Account withoutId(
            Money baselineBalance,
            ActivityWindow activityWindow
    ) {
        return new Account(null, baselineBalance, activityWindow);
    }

    public static Account withId(
            AccountId accountId,
            Money baselineBalance,
            ActivityWindow activityWindow
    ) {
        return new Account(accountId, baselineBalance, activityWindow);
    }

    public Optional<AccountId> getId() {
        return Optional.ofNullable(this.id);
    }

    public Money calculateBalance() {
        return Money.add(
                this.baselineBalance,
                this.activityWindow.calculateBalance(this.id)
        );
    }

    public boolean withdraw(Money money, AccountId targetAccountId) {
        if (!mayWithdraw(money)) {
            return false;
        }

        Activity withdrawal = new Activity(
                this.id,
                this.id,
                targetAccountId,
                LocalDateTime.now(),
                money
        );

        this.activityWindow.addActivity(withdrawal);

        return true;
    }

    private boolean mayWithdraw(Money money) {
        return Money.add(
                this.calculateBalance(),
                money.negate()
        ).isPositive();
    }

    public boolean deposit(Money money, AccountId sourceAccountId) {
        Activity deposit = new Activity(
                this.id,
                sourceAccountId,
                this.id,
                LocalDateTime.now(),
                money
        );

        this.activityWindow.addActivity(deposit);

        return true;
    }

    @Value
    public static class AccountId {
        Long value;
    }
}
