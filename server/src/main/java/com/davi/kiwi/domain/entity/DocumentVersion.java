package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DocumentVersion {

    private String id;
    private String documentId;
    private String title;
    private String content;
    private String publisherId;
    private long publishTimestamp;

    public void publish(long publishTimestamp) {
        this.publishTimestamp = publishTimestamp;
    }
}
