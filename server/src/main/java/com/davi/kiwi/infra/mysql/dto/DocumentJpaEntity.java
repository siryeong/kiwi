package com.davi.kiwi.infra.mysql.dto;

import com.davi.kiwi.domain.entity.Document;
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
@Table(name = "document")
public class DocumentJpaEntity {

    @Id
    private String id;
    private String spaceId;
    private String parentId;
    private String latestVersionId;

    public static DocumentJpaEntity from(Document document) {
        return DocumentJpaEntity.builder()
            .id(document.getId())
            .spaceId(document.getSpaceId())
            .parentId(document.getParentId())
            .latestVersionId(document.getLatestVersionId())
            .build();
    }

    public Document toDomain() {
        return Document.builder()
            .id(id)
            .spaceId(spaceId)
            .parentId(parentId)
            .latestVersionId(latestVersionId)
            .build();
    }
}
