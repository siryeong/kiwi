package com.davi.kiwi.domain.repository;

import com.davi.kiwi.domain.entity.SpaceMember;
import java.util.Optional;

public interface SpaceMemberRepository {

    void save(SpaceMember spaceMember);

    void delete(SpaceMember spaceMember);

    Optional<SpaceMember> findById(String id);
}
