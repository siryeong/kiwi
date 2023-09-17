package com.davi.kiwi.infra.mysql.repository.space;

import com.davi.kiwi.domain.entity.Space;
import com.davi.kiwi.domain.repository.SpaceRepository;
import com.davi.kiwi.infra.mysql.dto.SpaceJpaEntity;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SpaceRepositoryImpl implements SpaceRepository {

    private final SpaceJpaRepository spaceJpaRepository;

    @Override
    public void save(Space space) {
        SpaceJpaEntity spaceJpaEntity = SpaceJpaEntity.from(space);
        spaceJpaRepository.save(spaceJpaEntity);
    }

    @Override
    public void delete(Space space) {
        UUID uuid = UUID.fromString(space.getId());
        SpaceJpaEntity spaceJpaEntity = spaceJpaRepository.findById(uuid)
            .orElseThrow();
        spaceJpaRepository.delete(spaceJpaEntity);
    }

    @Override
    public Optional<Space> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return spaceJpaRepository.findById(uuid)
            .map(SpaceJpaEntity::toDomain);
    }

}
