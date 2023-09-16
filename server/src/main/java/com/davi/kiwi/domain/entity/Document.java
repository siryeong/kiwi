package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Document {

    private String id;
    private String spaceId;
    private String parentId;
    private String latestVersionId;

    public void publish(DocumentVersion documentVersion) {
        this.latestVersionId = documentVersion.getId();
    }
}
