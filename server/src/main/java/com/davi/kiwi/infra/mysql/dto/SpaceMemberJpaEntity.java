package com.davi.kiwi.infra.mysql.dto;

import com.davi.kiwi.domain.entity.SpaceMember;
import com.davi.kiwi.domain.entity.SpaceMemberRole;
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
@Table(name = "space_member")
public class SpaceMemberJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID spaceId;
    private UUID memberId;
    private SpaceMemberRole role;

    public static SpaceMemberJpaEntity from(SpaceMember spaceMember) {
        UUID id = Optional.ofNullable(spaceMember.getId())
            .map(UUID::fromString)
            .orElse(null);
        UUID spaceId = UUID.fromString(spaceMember.getSpaceId());
        UUID memberId = UUID.fromString(spaceMember.getMemberId());

        return SpaceMemberJpaEntity.builder()
            .id(id)
            .spaceId(spaceId)
            .memberId(memberId)
            .role(spaceMember.getRole())
            .build();
    }

    public SpaceMember toDomain() {
        return SpaceMember.builder()
            .id(id.toString())
            .spaceId(spaceId.toString())
            .memberId(memberId.toString())
            .role(role)
            .build();
    }
}
