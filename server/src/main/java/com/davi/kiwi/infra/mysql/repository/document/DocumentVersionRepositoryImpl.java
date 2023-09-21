package com.davi.kiwi.infra.mysql.repository.document;

import com.davi.kiwi.domain.entity.DocumentVersion;
import com.davi.kiwi.domain.repository.DocumentVersionRepository;
import com.davi.kiwi.infra.mysql.persistent.DocumentVersionPersistent;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DocumentVersionRepositoryImpl implements DocumentVersionRepository {

    private final DocumentVersionJpaRepository documentVersionJpaRepository;

    @Override
    public void save(DocumentVersion documentVersion) {
        DocumentVersionPersistent documentVersionPersistent = DocumentVersionPersistent.from(documentVersion);
        documentVersionJpaRepository.save(documentVersionPersistent);
    }

    @Override
    public void delete(DocumentVersion documentVersion) {
        UUID uuid = UUID.fromString(documentVersion.getId());
        DocumentVersionPersistent documentVersionPersistent = documentVersionJpaRepository.findById(uuid)
            .orElseThrow();
        documentVersionJpaRepository.delete(documentVersionPersistent);
    }

    @Override
    public Optional<DocumentVersion> findById(String id) {
        return documentVersionJpaRepository.findById(UUID.fromString(id))
            .map(DocumentVersionPersistent::toDomain);
    }
}
