package com.davi.kiwi.infra.mysql.repository.document;

import com.davi.kiwi.infra.mysql.persistent.DocumentVersionPersistent;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentVersionJpaRepository extends JpaRepository<DocumentVersionPersistent, UUID> {

}
