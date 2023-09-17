package com.davi.kiwi.application.service;

import com.davi.kiwi.domain.repository.SpaceMemberRepository;
import com.davi.kiwi.domain.repository.SpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpaceService {
    private final SpaceRepository spaceRepository;
    private final SpaceMemberRepository spaceMemberRepository;
}
