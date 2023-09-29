package com.davi.kiwi.domain.repository;

import com.davi.kiwi.domain.entity.Member;
import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    void delete(Member member);

    Optional<Member> findById(String id);

    Optional<Member> findByEmail(String email);
}
