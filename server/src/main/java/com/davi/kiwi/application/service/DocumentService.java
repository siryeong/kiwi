package com.davi.kiwi.application.service;

import com.davi.kiwi.domain.entity.Document;
import com.davi.kiwi.domain.entity.DocumentVersion;
import com.davi.kiwi.domain.repository.DocumentRepository;
import com.davi.kiwi.domain.repository.DocumentVersionRepository;
import com.davi.kiwi.domain.service.TimeProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentVersionRepository documentVersionRepository;
    private final TimeProvider timeProvider;

    public void publish(Document document, DocumentVersion documentVersion) {
        document.publish(documentVersion);
        documentVersion.publish(timeProvider.currentTimestampMillis());
        documentVersionRepository.save(documentVersion);
        documentRepository.save(document);
    }

    public void create(Document document) {
        documentRepository.save(document);
    }

    public Document getById(String documentId) {
        return documentRepository.findById(documentId).orElseThrow(() -> new RuntimeException("Document not found"));
    }
}
