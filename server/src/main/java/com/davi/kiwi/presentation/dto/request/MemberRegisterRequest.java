package com.davi.kiwi.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record MemberRegisterRequest(
    @NotEmpty @Email String email,
    String name,
    @NotEmpty String password
) {

}
