package com.davi.kiwi.infra.mysql.repository.space;

import com.davi.kiwi.domain.entity.Space;
import com.davi.kiwi.domain.repository.SpaceRepository;
import com.davi.kiwi.infra.mysql.persistent.SpacePersistent;
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
        SpacePersistent spacePersistent = SpacePersistent.from(space);
        spaceJpaRepository.save(spacePersistent);
    }

    @Override
    public void delete(Space space) {
        UUID uuid = UUID.fromString(space.getId());
        SpacePersistent spacePersistent = spaceJpaRepository.findById(uuid)
            .orElseThrow();
        spaceJpaRepository.delete(spacePersistent);
    }

    @Override
    public Optional<Space> findById(String id) {
        UUID uuid = UUID.fromString(id);
        return spaceJpaRepository.findById(uuid)
            .map(SpacePersistent::toDomain);
    }

}
