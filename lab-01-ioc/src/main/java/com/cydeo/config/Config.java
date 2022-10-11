package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
@ComponentScan("com.cydeo")
public class Config {

    @Bean
    public Currency currency(){
        Currency currency = new Currency();
        currency.setCode("DLR");
        currency.setName("Dollar");
        return currency;
    }
    @Bean
    public Saving saving(){
        Saving saving = new Saving();
        saving.setAccountId(UUID.randomUUID());
        saving.setAmount(BigDecimal.valueOf(500));
        saving.setCurrency(new Currency());
        return saving;
    }

    @Bean
    public Current current(){
        Current current = new Current();
        current.setAccountId(UUID.randomUUID());
        current.setAmount(BigDecimal.valueOf(500));
        return current;
    }
}
