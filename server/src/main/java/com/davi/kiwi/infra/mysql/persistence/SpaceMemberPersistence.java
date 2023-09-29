package com.davi.kiwi.infra.mysql.persistence;

import com.davi.kiwi.domain.entity.SpaceMember;
import com.davi.kiwi.domain.entity.SpaceMemberRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class SpaceMemberPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID spaceId;
    private UUID memberId;
    @Enumerated(EnumType.STRING)
    private SpaceMemberRole role;

    public static SpaceMemberPersistence from(SpaceMember spaceMember) {
        UUID id = Optional.ofNullable(spaceMember.getId())
            .map(UUID::fromString)
            .orElse(null);
        UUID spaceId = UUID.fromString(spaceMember.getSpaceId());
        UUID memberId = UUID.fromString(spaceMember.getMemberId());

        return SpaceMemberPersistence.builder()
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
