package com.davi.kiwi.application.service;

import com.davi.kiwi.application.exception.ServiceException;
import com.davi.kiwi.domain.entity.Member;
import com.davi.kiwi.domain.repository.MemberRepository;
import com.davi.kiwi.domain.service.TimeProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TimeProvider timeProvider;

    public Member getById(String id) {
        return memberRepository.findById(id)
            .orElseThrow(() -> new ServiceException("Member not found"));
    }

    @Transactional
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Transactional
    public void register(Member member) {
        member.registeredAt(timeProvider.currentTimestampMillis());
        memberRepository.save(member);
    }

    public Member getByEmail(String email) {
        return memberRepository.findByEmail(email)
            .orElseThrow(() -> new ServiceException("Member not found"));
    }
}
