package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Space {

    private String id;
    private String name;
    private String description;
}
