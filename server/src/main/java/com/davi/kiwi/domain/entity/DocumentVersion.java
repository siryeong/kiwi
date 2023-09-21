package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DocumentVersion {

    private String id;
    private String documentId;
    private String title;
    private String content;
    private String publisherId;
    private long publishTimestamp;

    @Builder
    public DocumentVersion(String id, String documentId, String title, String content, String publisherId, long publishTimestamp) {
        this.id = id;
        this.documentId = documentId;
        this.title = title;
        this.content = content;
        this.publisherId = publisherId;
        this.publishTimestamp = publishTimestamp;
    }

    public void publish(long publishTimestamp) {
        this.publishTimestamp = publishTimestamp;
    }
}
