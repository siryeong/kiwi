package com.davi.kiwi.presentation.dto.response;

import com.davi.kiwi.domain.entity.Token;

public record JwtAuthenticationResponse(String token) {
    public static JwtAuthenticationResponse from(Token token) {
        return new JwtAuthenticationResponse(token.getValue());
    }
}
