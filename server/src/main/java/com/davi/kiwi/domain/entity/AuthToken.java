package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthToken {
    private String value;
    private AuthTokenType type = AuthTokenType.BEARER;

    @Builder
    public AuthToken(String value, AuthTokenType type) {
        this.value = value;
        this.type = type;
    }

}
