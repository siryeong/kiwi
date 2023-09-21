package com.davi.kiwi.infra.mysql.repository.document;

import com.davi.kiwi.infra.mysql.persistent.DocumentPersistent;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentJpaRepository extends JpaRepository<DocumentPersistent, UUID> {

}
