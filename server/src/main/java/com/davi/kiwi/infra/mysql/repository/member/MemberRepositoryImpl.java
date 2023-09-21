package com.davi.kiwi.infra.mysql.repository.member;

import com.davi.kiwi.domain.entity.Member;
import com.davi.kiwi.domain.repository.MemberRepository;
import com.davi.kiwi.infra.mysql.persistent.MemberPersistent;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public void save(Member member) {
        MemberPersistent memberPersistent = MemberPersistent.from(member);
        memberJpaRepository.save(memberPersistent);
    }

    @Override
    public void delete(Member member) {
        UUID uuid = UUID.fromString(member.getId());
        MemberPersistent memberPersistent = memberJpaRepository.findById(uuid)
            .orElseThrow();
        memberJpaRepository.delete(memberPersistent);
    }

    @Override
    public Optional<Member> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return memberJpaRepository.findById(uuid)
            .map(MemberPersistent::toDomain);
    }
}
