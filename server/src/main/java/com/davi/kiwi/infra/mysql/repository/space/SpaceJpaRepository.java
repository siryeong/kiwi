package com.davi.kiwi.infra.mysql.repository.space;

import com.davi.kiwi.infra.mysql.persistence.SpacePersistence;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceJpaRepository extends JpaRepository<SpacePersistence, UUID> {

}
