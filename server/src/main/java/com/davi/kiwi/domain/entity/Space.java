package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Space {

    private String id;
    private String name;
    private String description;

    @Builder
    public Space(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
