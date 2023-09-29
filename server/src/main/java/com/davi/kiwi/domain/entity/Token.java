package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Token {
    private String value;
    private TokenType type = TokenType.BEARER;

    @Builder
    public Token(String value, TokenType type) {
        this.value = value;
        this.type = type;
    }

}
