package com.cydeo.account;

import com.cydeo.Currency;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
@Component
public class Current {

    @Autowired
    private Currency currency;
    private BigDecimal amount;
    private UUID accountId;

    public void initialize(){
        System.out.println("current account " + "currency: "+ currency.getCode() + "amount: " + amount + "accountId" + accountId);
    }
}
