package com.davi.kiwi.infra.mysql.repository.space;

import com.davi.kiwi.domain.entity.Space;
import com.davi.kiwi.domain.repository.SpaceRepository;
import com.davi.kiwi.infra.mysql.persistence.SpacePersistence;
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
        SpacePersistence spacePersistence = SpacePersistence.from(space);
        spaceJpaRepository.save(spacePersistence);
    }

    @Override
    public void delete(Space space) {
        UUID uuid = UUID.fromString(space.getId());
        SpacePersistence spacePersistence = spaceJpaRepository.findById(uuid)
            .orElseThrow();
        spaceJpaRepository.delete(spacePersistence);
    }

    @Override
    public Optional<Space> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return spaceJpaRepository.findById(uuid)
            .map(SpacePersistence::toDomain);
    }

}
