package com.davi.kiwi.infra.security.service;

import com.davi.kiwi.domain.entity.Member;
import com.davi.kiwi.domain.entity.Token;
import com.davi.kiwi.domain.entity.TokenType;
import com.davi.kiwi.domain.service.TimeProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtProvider {

    private final String secretKey;
    private final long validityDays;
    private final TimeProvider timeProvider;

    public JwtProvider(
        @Value("${jwt.secret-key}") String secretKey,
        @Value("${jwt.validity-days}") long validityDays,
        TimeProvider timeProvider
    ) {
        this.secretKey = secretKey;
        this.validityDays = validityDays;
        this.timeProvider = timeProvider;
    }

    public Token generateToken(Member member) {
        return generateToken(new HashMap<>(), member);
    }

    public Token generateToken(Map<String, Object> claims, Member member) {
        String token = Jwts.builder()
            .setClaims(claims)
            .setSubject(member.getId())
            .setIssuedAt(new Date(timeProvider.currentTimestampMillis()))
            .setExpiration(new Date(timeProvider.currentTimestampMillis() + timeProvider.daysToMillis(validityDays)))
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact();

        return Token.builder()
            .value(token)
            .type(TokenType.BEARER)
            .build();
    }

    public boolean validateToken(String token, Member member) {
        final String extractedId = extractMemberId(token);
        return (extractedId.equals(member.getId()) && !isTokenExpired(token));
    }

    public String extractMemberId(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date(timeProvider.currentTimestampMillis()));
    }


    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    private Key getSigningKey() {
        byte[] secretKeyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secretKeyBytes);
    }
}
