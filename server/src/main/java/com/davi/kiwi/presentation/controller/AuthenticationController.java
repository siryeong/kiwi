package com.davi.kiwi.presentation.controller;

import com.davi.kiwi.domain.entity.AuthToken;
import com.davi.kiwi.infra.security.service.AuthenticationService;
import com.davi.kiwi.presentation.dto.request.MemberAuthenticationRequest;
import com.davi.kiwi.presentation.dto.request.MemberRegisterRequest;
import com.davi.kiwi.presentation.dto.response.JwtAuthenticationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<JwtAuthenticationResponse> register(
        @RequestBody @Valid MemberRegisterRequest request
    ) {
        AuthToken authToken = authenticationService.register(request.email(), request.name(), request.password());
        return ResponseEntity.ok(JwtAuthenticationResponse.from(authToken));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(
        @RequestBody @Valid MemberAuthenticationRequest request
    ) {
        AuthToken authToken = authenticationService.authenticate(request.email(), request.password());
        return ResponseEntity.ok(JwtAuthenticationResponse.from(authToken));
    }
}
