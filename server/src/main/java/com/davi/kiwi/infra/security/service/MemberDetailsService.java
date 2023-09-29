package com.davi.kiwi.infra.security.service;

import com.davi.kiwi.application.service.MemberService;
import com.davi.kiwi.domain.entity.Member;
import com.davi.kiwi.infra.security.adapter.MemberDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberService.getById(username);
        return new MemberDetails(member);
    }
}
