package com.davi.kiwi.infra.mysql.dto;

import com.davi.kiwi.domain.entity.Document;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Optional;
import java.util.UUID;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String spaceId;
    private String parentId;
    private String latestVersionId;

    public static DocumentJpaEntity from(Document document) {
        UUID uuid = Optional.ofNullable(document.getId())
            .map(UUID::fromString)
            .orElse(null);

        return DocumentJpaEntity.builder()
            .id(uuid)
            .spaceId(document.getSpaceId())
            .parentId(document.getParentId())
            .latestVersionId(document.getLatestVersionId())
            .build();
    }

    public Document toDomain() {
        return Document.builder()
            .id(id.toString())
            .spaceId(spaceId)
            .parentId(parentId)
            .latestVersionId(latestVersionId)
            .build();
    }
}
