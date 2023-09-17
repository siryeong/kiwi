package com.davi.kiwi.domain.repository;

import com.davi.kiwi.domain.entity.Space;
import java.util.Optional;

public interface SpaceRepository {

    void save(Space space);

    void delete(Space space);

    Optional<Space> findById(String id);
}
