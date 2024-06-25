package com.example.cqrsbankingapp.web.security.jwt;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "security.jwt")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtProperties {

     String secret;
     Duration access;
     Duration refresh;

}
