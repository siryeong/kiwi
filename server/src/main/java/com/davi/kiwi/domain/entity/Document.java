package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Document {

    private String id;
    private String spaceId;
    private String parentId;
    private String latestVersionId;

    @Builder
    public Document(String id, String spaceId, String parentId, String latestVersionId) {
        this.id = id;
        this.spaceId = spaceId;
        this.parentId = parentId;
        this.latestVersionId = latestVersionId;
    }

    public void publish(DocumentVersion documentVersion) {
        this.latestVersionId = documentVersion.getId();
    }

}
