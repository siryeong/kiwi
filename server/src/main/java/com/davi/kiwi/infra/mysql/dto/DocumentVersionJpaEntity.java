package com.davi.kiwi.infra.mysql.dto;

import com.davi.kiwi.domain.entity.DocumentVersion;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document_version")
public class DocumentVersionJpaEntity {

    @Id
    private String id;
    private String documentId;
    private String title;
    private String content;
    private String publisherId;
    private long publishTimestamp;

    public static DocumentVersionJpaEntity from(DocumentVersion documentVersion) {
        return DocumentVersionJpaEntity.builder()
            .id(documentVersion.getId())
            .documentId(documentVersion.getDocumentId())
            .title(documentVersion.getTitle())
            .content(documentVersion.getContent())
            .publisherId(documentVersion.getPublisherId())
            .publishTimestamp(documentVersion.getPublishTimestamp())
            .build();
    }

    public DocumentVersion toDomain() {
        return DocumentVersion.builder()
            .id(id)
            .documentId(documentId)
            .title(title)
            .content(content)
            .publisherId(publisherId)
            .publishTimestamp(publishTimestamp)
            .build();
    }
}
