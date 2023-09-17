package com.davi.kiwi.infra.mysql.repository.document;

import com.davi.kiwi.domain.entity.DocumentVersion;
import com.davi.kiwi.domain.repository.DocumentVersionRepository;
import com.davi.kiwi.infra.mysql.dto.DocumentVersionJpaEntity;
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
        DocumentVersionJpaEntity documentVersionJpaEntity = DocumentVersionJpaEntity.from(documentVersion);
        documentVersionJpaRepository.save(documentVersionJpaEntity);
    }

    @Override
    public void delete(DocumentVersion documentVersion) {
        UUID uuid = UUID.fromString(documentVersion.getId());
        DocumentVersionJpaEntity documentVersionJpaEntity = documentVersionJpaRepository.findById(uuid)
            .orElseThrow();
        documentVersionJpaRepository.delete(documentVersionJpaEntity);
    }

    @Override
    public Optional<DocumentVersion> findById(String id) {
        return documentVersionJpaRepository.findById(UUID.fromString(id))
            .map(DocumentVersionJpaEntity::toDomain);
    }
}
