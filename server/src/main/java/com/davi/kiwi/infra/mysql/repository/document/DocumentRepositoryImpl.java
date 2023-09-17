package com.davi.kiwi.infra.mysql.repository.document;

import com.davi.kiwi.domain.entity.Document;
import com.davi.kiwi.domain.repository.DocumentRepository;
import com.davi.kiwi.infra.mysql.dto.DocumentJpaEntity;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DocumentRepositoryImpl implements DocumentRepository {

    private final DocumentJpaRepository documentJpaRepository;

    @Override
    public void save(Document document) {
        DocumentJpaEntity documentJpaEntity = DocumentJpaEntity.from(document);
        documentJpaRepository.save(documentJpaEntity);
    }

    @Override
    public void delete(Document document) {
        UUID uuid = UUID.fromString(document.getId());
        DocumentJpaEntity documentJpaEntity = documentJpaRepository.findById(uuid)
            .orElseThrow();
        documentJpaRepository.delete(documentJpaEntity);
    }

    @Override
    public Optional<Document> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return documentJpaRepository.findById(uuid)
            .map(DocumentJpaEntity::toDomain);
    }
}
