package com.davi.kiwi.infra.mysql;

import com.davi.kiwi.domain.entity.Document;
import com.davi.kiwi.domain.repository.DocumentRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentJpaRepository implements DocumentRepository {

    @Override
    public void save(Document document) {
        // Todo. JPA 의존성 추가 후 구현
    }

    @Override
    public void delete(Document document) {
        // Todo. JPA 의존성 추가 후 구현
    }

    @Override
    public Optional<Document> findById(String id) {
        return Optional.empty();
    }
}
