package com.davi.kiwi.infra.mysql.dto;

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
public class MemberJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String name;
    private String password;

    public static MemberJpaEntity from(Member member) {
        UUID id = Optional.ofNullable(member.getId())
            .map(UUID::fromString)
            .orElse(null);

        return MemberJpaEntity.builder()
            .id(id)
            .email(member.getEmail())
            .name(member.getName())
            .password(member.getPassword())
            .build();
    }

    public Member toDomain() {
        return Member.builder()
            .id(id.toString())
            .email(email)
            .name(name)
            .password(password)
            .build();
    }
}
