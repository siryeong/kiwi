package com.davi.kiwi.infra.mysql.repository.space;

import com.davi.kiwi.infra.mysql.dto.SpaceMemberJpaEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceMemberJpaRepository extends JpaRepository<SpaceMemberJpaEntity, UUID> {

}
