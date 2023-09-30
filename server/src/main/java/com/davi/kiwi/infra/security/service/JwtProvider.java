package com.davi.kiwi.infra.security.service;

import com.davi.kiwi.domain.entity.Member;
import com.davi.kiwi.domain.entity.AuthToken;
import com.davi.kiwi.domain.entity.AuthTokenType;
import com.davi.kiwi.domain.service.TimeProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtProvider {

    private final String secretKey;
    private final long expirationMillis;
    private final TimeProvider timeProvider;

    public JwtProvider(
        @Value("${jwt.secret-key}") String secretKey,
        @Value("${jwt.expiration-millis}") long expirationMillis,
        TimeProvider timeProvider
    ) {
        this.secretKey = secretKey;
        this.expirationMillis = expirationMillis;
        this.timeProvider = timeProvider;
    }

    public AuthToken generateToken(Member member) {
        long now = timeProvider.currentTimestampMillis();
        String token = Jwts.builder()
            .setSubject(member.getId())
            .setClaims(new HashMap<>())
            .setIssuedAt(new Date(now))
            .setExpiration(new Date(now + expirationMillis))
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact();

        return AuthToken.builder()
            .value(token)
            .type(AuthTokenType.BEARER)
            .build();
    }

    public boolean validateToken(String token, Member member) {
        long now = timeProvider.currentTimestampMillis();
        final String extractedId = extractClaim(token, Claims::getSubject);
        return (extractedId.equals(member.getId()) && !extractClaim(token, Claims::getExpiration).before(new Date(now)));
    }

    public String extractMemberId(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
            .getBody();

        return claimsResolver.apply(claims);
    }

    private Key getSigningKey() {
        byte[] secretKeyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secretKeyBytes);
    }
}
