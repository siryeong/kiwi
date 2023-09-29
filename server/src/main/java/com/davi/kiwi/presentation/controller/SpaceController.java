package com.davi.kiwi.presentation.controller;

import com.davi.kiwi.application.service.SpaceService;
import com.davi.kiwi.domain.entity.Space;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spaces")
@RequiredArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;

    @GetMapping
    public ResponseEntity<List<Space>> getSpaces() {
        return ResponseEntity.ok(spaceService.getSpaces());
    }
}
