package com.davi.kiwi.infra.mysql.repository.space;

import com.davi.kiwi.domain.entity.SpaceMember;
import com.davi.kiwi.domain.repository.SpaceMemberRepository;
import com.davi.kiwi.infra.mysql.persistence.SpaceMemberPersistence;
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
        SpaceMemberPersistence spaceMemberPersistence = SpaceMemberPersistence.from(spaceMember);
        spaceMemberJpaRepository.save(spaceMemberPersistence);
    }

    @Override
    public void delete(SpaceMember spaceMember) {
        UUID uuid = UUID.fromString(spaceMember.getId());
        SpaceMemberPersistence spaceMemberPersistence = spaceMemberJpaRepository.findById(uuid)
            .orElseThrow();
        spaceMemberJpaRepository.delete(spaceMemberPersistence);
    }

    @Override
    public Optional<SpaceMember> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return spaceMemberJpaRepository.findById(uuid)
            .map(SpaceMemberPersistence::toDomain);
    }
}
