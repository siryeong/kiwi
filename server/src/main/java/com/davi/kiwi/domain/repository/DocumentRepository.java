package com.davi.kiwi.domain.repository;

import com.davi.kiwi.domain.entity.Document;
import java.util.Optional;

public interface DocumentRepository {

    void save(Document document);

    void delete(Document document);

    Optional<Document> findById(String id);
}
