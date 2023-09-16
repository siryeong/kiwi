package com.davi.kiwi.presentation.dto.request;

import com.davi.kiwi.domain.entity.DocumentVersion;

public record DocumentVersionRequest(String documentId, String title, String content, String publisherId) {

    public DocumentVersion toEntity() {
        return DocumentVersion.builder()
            .documentId(documentId)
            .title(title)
            .content(content)
            .publisherId(publisherId)
            .build();
    }
}
