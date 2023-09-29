package com.davi.kiwi.application.service;

import com.davi.kiwi.domain.entity.Space;
import com.davi.kiwi.domain.repository.SpaceMemberRepository;
import com.davi.kiwi.domain.repository.SpaceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpaceService {
    private final SpaceRepository spaceRepository;
    private final SpaceMemberRepository spaceMemberRepository;

    public List<Space> getSpaces() {
        return spaceRepository.findAll();
    }
}
