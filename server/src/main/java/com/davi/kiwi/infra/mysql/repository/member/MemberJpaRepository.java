package com.davi.kiwi.infra.mysql.repository.member;

import com.davi.kiwi.infra.mysql.persistence.MemberPersistence;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberPersistence, UUID> {

    Optional<MemberPersistence> findByEmail(String email);
}
