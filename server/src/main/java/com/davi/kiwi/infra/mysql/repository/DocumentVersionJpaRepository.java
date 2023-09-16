package com.davi.kiwi.infra.mysql.repository;

import com.davi.kiwi.infra.mysql.dto.DocumentVersionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentVersionJpaRepository extends JpaRepository<DocumentVersionJpaEntity, String> {

}
