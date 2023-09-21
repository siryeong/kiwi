package com.davi.kiwi.infra.mysql.repository.member;

import com.davi.kiwi.infra.mysql.persistent.MemberPersistent;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberPersistent, UUID> {

}
