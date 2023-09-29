package com.davi.kiwi.infra.security.service;

import com.davi.kiwi.domain.service.TimeProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final String secretKey;
    private final long validityDays;
    private final TimeProvider timeProvider;

    public JwtService(
        @Value("${jwt.secret-key}") String secretKey,
        @Value("${jwt.token-validity-days}") long validityDays,
        TimeProvider timeProvider
    ) {
        this.secretKey = secretKey;
        this.validityDays = validityDays;
        this.timeProvider = timeProvider;
    }


    public String generateToken(Map<String, Object> claims, UserDetails member) {
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(member.getUsername())
            .setIssuedAt(new Date(timeProvider.currentTimestampMillis()))
            .setExpiration(new Date(timeProvider.currentTimestampMillis() + timeProvider.daysToMillis(validityDays)))
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    public boolean validateToken(String token, UserDetails member) {
        final String extractedId = extractMemberId(token);
        return (extractedId.equals(member.getUsername()) && !isTokenExpired(token));
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
