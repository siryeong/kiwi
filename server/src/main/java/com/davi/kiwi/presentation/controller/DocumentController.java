package com.davi.kiwi.presentation.controller;

import com.davi.kiwi.application.service.DocumentService;
import com.davi.kiwi.domain.entity.Document;
import com.davi.kiwi.domain.entity.DocumentVersion;
import com.davi.kiwi.presentation.dto.request.DocumentRequest;
import com.davi.kiwi.presentation.dto.request.DocumentVersionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public void create(@RequestBody DocumentRequest request) {
        Document document = request.toEntity();
        documentService.create(document);
    }

    @PostMapping("/{documentId}/versions")
    public void publish(@PathVariable String documentId, @RequestBody DocumentVersionRequest request) {
        Document document = documentService.findById(documentId);
        DocumentVersion documentVersion = request.toEntity();
        documentService.publish(document, documentVersion);
    }

}
