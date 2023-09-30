package com.davi.kiwi.presentation.dto.response;

import com.davi.kiwi.domain.entity.AuthToken;

public record JwtAuthenticationResponse(String token) {
    public static JwtAuthenticationResponse from(AuthToken authToken) {
        return new JwtAuthenticationResponse(authToken.getValue());
    }
}
