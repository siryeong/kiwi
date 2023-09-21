package com.davi.kiwi.infra.mysql.persistent;

import com.davi.kiwi.domain.entity.DocumentVersion;
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
@Table(name = "document_version")
public class DocumentVersionPersistent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID documentId;
    private String title;
    private String content;
    private UUID publisherId;
    private long publishTimestamp;

    public static DocumentVersionPersistent from(DocumentVersion documentVersion) {
        UUID uuid = Optional.ofNullable(documentVersion.getId())
            .map(UUID::fromString)
            .orElse(null);
        UUID documentId = UUID.fromString(documentVersion.getDocumentId());
        UUID publisherId = UUID.fromString(documentVersion.getPublisherId());

        return DocumentVersionPersistent.builder()
            .id(uuid)
            .documentId(documentId)
            .title(documentVersion.getTitle())
            .content(documentVersion.getContent())
            .publisherId(publisherId)
            .publishTimestamp(documentVersion.getPublishTimestamp())
            .build();
    }

    public DocumentVersion toDomain() {
        return DocumentVersion.builder()
            .id(id.toString())
            .documentId(documentId.toString())
            .title(title)
            .content(content)
            .publisherId(publisherId.toString())
            .publishTimestamp(publishTimestamp)
            .build();
    }
}
