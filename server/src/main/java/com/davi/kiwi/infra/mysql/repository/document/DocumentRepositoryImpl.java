package com.davi.kiwi.infra.mysql.repository.document;

import com.davi.kiwi.domain.entity.Document;
import com.davi.kiwi.domain.repository.DocumentRepository;
import com.davi.kiwi.infra.mysql.persistence.DocumentPersistence;
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
        DocumentPersistence documentPersistence = DocumentPersistence.from(document);
        documentJpaRepository.save(documentPersistence);
    }

    @Override
    public void delete(Document document) {
        UUID uuid = UUID.fromString(document.getId());
        DocumentPersistence documentPersistence = documentJpaRepository.findById(uuid)
            .orElseThrow();
        documentJpaRepository.delete(documentPersistence);
    }

    @Override
    public Optional<Document> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return documentJpaRepository.findById(uuid)
            .map(DocumentPersistence::toDomain);
    }
}
