package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {

    private String id;
    private String email;
    private String name;
    private String password;
}
