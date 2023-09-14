package com.davi.kiwi.domain.repository;

import com.davi.kiwi.domain.entity.DocumentVersion;
import java.util.Optional;

public interface DocumentVersionRepository {

    void save(DocumentVersion documentVersion);

    void delete(DocumentVersion documentVersion);

    Optional<DocumentVersion> findById(Long id);
}
