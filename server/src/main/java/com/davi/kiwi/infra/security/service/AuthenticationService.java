package com.davi.kiwi.infra.security.service;

import com.davi.kiwi.application.service.MemberService;
import com.davi.kiwi.domain.entity.Member;
import com.davi.kiwi.domain.entity.MemberRole;
import com.davi.kiwi.domain.entity.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final MemberService memberService;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public Token register(String email, String name, String password) {
        Member member = Member.builder()
            .email(email)
            .name(name)
            .password(passwordEncoder.encode(password))
            .role(MemberRole.USER)
            .build();
        memberService.register(member);
        return jwtProvider.generateToken(member);
    }

    public Token authenticate(String email, String password) {
        Member member = memberService.getByEmail(email);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(member.getId(), password));
        return jwtProvider.generateToken(member);
    }
}
