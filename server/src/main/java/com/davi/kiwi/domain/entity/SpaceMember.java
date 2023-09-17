package com.davi.kiwi.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpaceMember {

    private String id;
    private String spaceId;
    private String memberId;
    private SpaceMemberRole role;
}
