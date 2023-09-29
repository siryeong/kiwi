package com.davi.kiwi.infra.security.service;

import com.davi.kiwi.domain.entity.Member;
import com.davi.kiwi.domain.repository.MemberRepository;
import com.davi.kiwi.infra.security.adapter.MemberDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findById(username)
            .orElseThrow(() -> new UsernameNotFoundException("Member not found"));
        return new MemberDetails(member);
    }
}
