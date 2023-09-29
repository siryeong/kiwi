package com.davi.kiwi.domain.entity;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Member implements Serializable {

    private String id;
    private String email;
    private String name;
    private String password;
    private MemberRole role;
    private long joinTimestamp;
    private long lastLoginTimestamp;

    @Builder
    public Member(String id, String email, String name, String password, MemberRole role, long joinTimestamp, long lastLoginTimestamp) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.joinTimestamp = joinTimestamp;
        this.lastLoginTimestamp = lastLoginTimestamp;
    }

    public void registeredAt(long joinTimestamp) {
        this.joinTimestamp = joinTimestamp;
        this.lastLoginTimestamp = joinTimestamp;
    }
}
