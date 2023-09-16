package com.davi.kiwi.infra.mysql.repository;

import com.davi.kiwi.domain.entity.Document;
import com.davi.kiwi.domain.repository.DocumentRepository;
import com.davi.kiwi.infra.mysql.dto.DocumentJpaEntity;
import java.util.Optional;
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
        DocumentJpaEntity documentJpaEntity = documentJpaRepository.findById(document.getId())
            .orElseThrow();
        documentJpaRepository.delete(documentJpaEntity);
    }

    @Override
    public Optional<Document> findById(String id) {
        return documentJpaRepository.findById(id)
            .map(DocumentJpaEntity::toDomain);
    }
}
