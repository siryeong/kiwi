package com.davi.kiwi.infra.mysql.repository.document;

import com.davi.kiwi.infra.mysql.persistence.DocumentVersionPersistence;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentVersionJpaRepository extends JpaRepository<DocumentVersionPersistence, UUID> {

}
