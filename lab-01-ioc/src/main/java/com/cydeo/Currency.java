package com.cydeo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Currency {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }
}
