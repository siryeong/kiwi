package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Member {

    private String id;
    private String email;
    private String name;
    private String password;
    private long joinTimestamp;
    private long lastLoginTimestamp;

    @Builder
    public Member(String id, String email, String name, String password, long joinTimestamp, long lastLoginTimestamp) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.joinTimestamp = joinTimestamp;
        this.lastLoginTimestamp = lastLoginTimestamp;
    }

}
