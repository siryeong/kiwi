package com.davi.kiwi.infra.mysql.persistent;

import com.davi.kiwi.domain.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class MemberPersistent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String name;
    private String password;
    private long joinTimestamp;
    private long lastLoginTimestamp;

    public static MemberPersistent from(Member member) {
        UUID id = Optional.ofNullable(member.getId())
            .map(UUID::fromString)
            .orElse(null);

        return new MemberPersistent(
            id,
            member.getEmail(),
            member.getName(),
            member.getPassword(),
            member.getJoinTimestamp(),
            member.getLastLoginTimestamp()
        );
    }

    public Member toDomain() {
        return new Member(
            id.toString(),
            email,
            name,
            password,
            joinTimestamp,
            lastLoginTimestamp
        );
    }
}
