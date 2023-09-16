package com.davi.kiwi.presentation.dto.request;

import com.davi.kiwi.domain.entity.Document;

public record DocumentRequest(String spaceId, String parentId) {

    public Document toDomain() {
        return Document.builder()
            .spaceId(spaceId)
            .parentId(parentId)
            .build();
    }
}
