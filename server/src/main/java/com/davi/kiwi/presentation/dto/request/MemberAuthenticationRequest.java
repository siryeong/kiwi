package com.davi.kiwi.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record MemberAuthenticationRequest(
    @NotEmpty @Email String email,
    @NotEmpty String password
) {

}
