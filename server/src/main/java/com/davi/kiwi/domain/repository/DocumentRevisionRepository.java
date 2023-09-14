package com.davi.kiwi.domain.repository;

import com.davi.kiwi.domain.entity.DocumentRevision;
import java.util.Optional;

public interface DocumentRevisionRepository {

    void save(DocumentRevision documentRevision);

    void delete(DocumentRevision documentRevision);

    Optional<DocumentRevision> findById(Long id);
}
