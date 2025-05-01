package com.footalentgroup.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtService {
    private static final String EMAIL_CLAIM = "email";
    private static final String NAME_CLAIM = "name";
    private static final String ROLE_CLAIM = "role";

    private final String secret;
    private final String issuer;
    private final int expire;

    public JwtService(@Value("${jwt.secret}") String secret, @Value("${jwt.issuer}") String issuer, @Value("${jwt.expire}") int expire) {
        this.secret = secret;
        this.issuer = issuer;
        this.expire = expire;
    }

    public String extractToken(String bearer) {
        if (bearer != null && bearer.startsWith("Bearer ") && 3 == bearer.split("\\.").length) {
            return bearer.substring(7);
        } else {
            return "";
        }
    }

    public String createToken(String email, String name, String role) {
        return JWT.create()
                .withIssuer(this.issuer)
                .withIssuedAt(new Date())
                .withNotBefore(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + this.expire * 1000L))
                .withClaim(EMAIL_CLAIM, email)
                .withClaim(NAME_CLAIM, name)
                .withClaim(ROLE_CLAIM, role)
                .sign(getAlgorithm());
    }

    public String email(String authorization) {
        return this.verifyToken(authorization)
                .map(jwt -> jwt.getClaim(EMAIL_CLAIM).asString())
                .orElse(null);
    }

    public String name(String authorization) {
        return this.verifyToken(authorization)
                .map(jwt -> jwt.getClaim(NAME_CLAIM).asString())
                .orElse(null);
    }

    public String role(String authorization) {
        return this.verifyToken(authorization)
                .map(jwt -> jwt.getClaim(ROLE_CLAIM).asString())
                .orElse(null);
    }

    private Optional<DecodedJWT> verifyToken(String token) {
        try {
            return Optional.of(
                    JWT.require(getAlgorithm())
                    .withIssuer(this.issuer)
                    .build()
                    .verify(token)
            );
        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(this.secret);
    }
}
