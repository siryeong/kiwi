package com.davi.kiwi.infra.mysql.repository.member;

import com.davi.kiwi.domain.entity.Member;
import com.davi.kiwi.domain.repository.MemberRepository;
import com.davi.kiwi.infra.mysql.persistence.MemberPersistence;
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
        MemberPersistence memberPersistence = MemberPersistence.from(member);
        memberJpaRepository.save(memberPersistence);
    }

    @Override
    public void delete(Member member) {
        UUID uuid = UUID.fromString(member.getId());
        MemberPersistence memberPersistence = memberJpaRepository.findById(uuid)
            .orElseThrow();
        memberJpaRepository.delete(memberPersistence);
    }

    @Override
    public Optional<Member> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return memberJpaRepository.findById(uuid)
            .map(MemberPersistence::toDomain);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberJpaRepository.findByEmail(email)
            .map(MemberPersistence::toDomain);
    }
}
