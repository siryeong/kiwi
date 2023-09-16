package com.davi.kiwi.infra.mysql;

import com.davi.kiwi.domain.entity.DocumentVersion;
import com.davi.kiwi.domain.repository.DocumentVersionRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentVersionJpaRepository implements DocumentVersionRepository {

    @Override
    public void save(DocumentVersion documentVersion) {
        // Todo. JPA 의존성 추가 후 구현
    }

    @Override
    public void delete(DocumentVersion documentVersion) {
        // Todo. JPA 의존성 추가 후 구현
    }

    @Override
    public Optional<DocumentVersion> findById(Long id) {
        return Optional.empty();
    }
}
