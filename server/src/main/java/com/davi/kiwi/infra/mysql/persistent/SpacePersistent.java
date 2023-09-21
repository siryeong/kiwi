package com.davi.kiwi.infra.mysql.persistent;

import com.davi.kiwi.domain.entity.Space;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "space")
public class SpacePersistent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;

    public static SpacePersistent from(Space space) {
        UUID id = UUID.fromString(space.getId());

        return SpacePersistent.builder()
            .id(id)
            .name(space.getName())
            .description(space.getDescription())
            .build();
    }

    public Space toDomain() {
        return Space.builder()
            .id(id.toString())
            .name(name)
            .description(description)
            .build();
    }
}
