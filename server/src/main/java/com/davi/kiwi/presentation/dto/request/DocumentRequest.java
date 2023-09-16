package com.davi.kiwi.presentation.dto.request;

import com.davi.kiwi.domain.entity.Document;

public record DocumentRequest(String spaceId, String parentId) {

    public Document toEntity() {
        return Document.builder()
            .spaceId(spaceId)
            .parentId(parentId)
            .build();
    }
}
