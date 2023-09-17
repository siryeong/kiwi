package com.davi.kiwi.infra.mysql.repository.space;

import com.davi.kiwi.infra.mysql.dto.SpaceJpaEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceJpaRepository extends JpaRepository<SpaceJpaEntity, UUID> {

}
