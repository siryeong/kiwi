package com.davi.kiwi.infra.mysql.repository.document;

import com.davi.kiwi.infra.mysql.persistence.DocumentPersistence;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentJpaRepository extends JpaRepository<DocumentPersistence, UUID> {

}
