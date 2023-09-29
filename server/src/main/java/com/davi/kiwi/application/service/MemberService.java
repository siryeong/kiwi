package com.davi.kiwi.application.service;

import com.davi.kiwi.application.exception.ServiceException;
import com.davi.kiwi.domain.entity.Member;
import com.davi.kiwi.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getById(String id) {
        return memberRepository.findById(id)
            .orElseThrow(() -> new ServiceException("Member not found"));
    }
}
