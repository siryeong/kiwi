package com.davi.kiwi.infra.mysql.repository;

import com.davi.kiwi.infra.mysql.dto.DocumentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentJpaRepository extends JpaRepository<DocumentJpaEntity, String> {

}
