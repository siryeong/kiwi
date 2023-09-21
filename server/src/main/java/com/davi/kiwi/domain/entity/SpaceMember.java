package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SpaceMember {

    private String id;
    private String spaceId;
    private String memberId;
    private SpaceMemberRole role;

    @Builder
    public SpaceMember(String id, String spaceId, String memberId, SpaceMemberRole role) {
        this.id = id;
        this.spaceId = spaceId;
        this.memberId = memberId;
        this.role = role;
    }

}
