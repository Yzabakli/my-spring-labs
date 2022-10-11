package com.cydeo.loosely;

import java.math.BigDecimal;

public class BalanceManager {
    public boolean checkout(Balance balance, BigDecimal amount){
        BigDecimal customerBalanceAmount = balance.getAmount();

        return customerBalanceAmount.subtract(amount)
                .compareTo(BigDecimal.ZERO) > 0;
    }
}
