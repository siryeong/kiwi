package com.davi.kiwi.domain.entity;

import java.util.List;

public class Document {

    private String id;
    private Space space;
    private Document parent;
    private List<DocumentVersion> versions;
}
