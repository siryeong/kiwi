package com.davi.kiwi.infra.mysql.persistent;

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
public class DocumentPersistent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID spaceId;
    private UUID parentId;
    private UUID latestVersionId;

    public static DocumentPersistent from(Document document) {
        UUID id = Optional.ofNullable(document.getId())
            .map(UUID::fromString)
            .orElse(null);
        UUID spaceId = UUID.fromString(document.getSpaceId());
        UUID parentId = UUID.fromString(document.getParentId());
        UUID latestVersionId = UUID.fromString(document.getLatestVersionId());

        return DocumentPersistent.builder()
            .id(id)
            .spaceId(spaceId)
            .parentId(parentId)
            .latestVersionId(latestVersionId)
            .build();
    }

    public Document toDomain() {
        return Document.builder()
            .id(id.toString())
            .spaceId(spaceId.toString())
            .parentId(parentId.toString())
            .latestVersionId(latestVersionId.toString())
            .build();
    }
}
