package com.davi.kiwi.infra.mysql.repository;

import com.davi.kiwi.domain.entity.DocumentVersion;
import com.davi.kiwi.domain.repository.DocumentVersionRepository;
import com.davi.kiwi.infra.mysql.dto.DocumentVersionJpaEntity;
import java.util.Optional;
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
        DocumentVersionJpaEntity documentVersionJpaEntity = documentVersionJpaRepository.findById(documentVersion.getId())
            .orElseThrow();
        documentVersionJpaRepository.delete(documentVersionJpaEntity);
    }

    @Override
    public Optional<DocumentVersion> findById(String id) {
        return documentVersionJpaRepository.findById(id)
            .map(DocumentVersionJpaEntity::toDomain);
    }
}
