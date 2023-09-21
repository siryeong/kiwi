package com.davi.kiwi.infra.mysql.repository.space;

import com.davi.kiwi.infra.mysql.persistent.SpaceMemberPersistent;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceMemberJpaRepository extends JpaRepository<SpaceMemberPersistent, UUID> {

}
