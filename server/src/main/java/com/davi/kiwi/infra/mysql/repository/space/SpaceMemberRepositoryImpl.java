package com.davi.kiwi.infra.mysql.repository.space;

import com.davi.kiwi.domain.entity.SpaceMember;
import com.davi.kiwi.domain.repository.SpaceMemberRepository;
import com.davi.kiwi.infra.mysql.dto.SpaceMemberJpaEntity;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SpaceMemberRepositoryImpl implements SpaceMemberRepository {

    private final SpaceMemberJpaRepository spaceMemberJpaRepository;

    @Override
    public void save(SpaceMember spaceMember) {
        SpaceMemberJpaEntity spaceMemberJpaEntity = SpaceMemberJpaEntity.from(spaceMember);
        spaceMemberJpaRepository.save(spaceMemberJpaEntity);
    }

    @Override
    public void delete(SpaceMember spaceMember) {
        UUID uuid = UUID.fromString(spaceMember.getId());
        SpaceMemberJpaEntity spaceMemberJpaEntity = spaceMemberJpaRepository.findById(uuid)
            .orElseThrow();
        spaceMemberJpaRepository.delete(spaceMemberJpaEntity);
    }

    @Override
    public Optional<SpaceMember> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return spaceMemberJpaRepository.findById(uuid)
            .map(SpaceMemberJpaEntity::toDomain);
    }
}
