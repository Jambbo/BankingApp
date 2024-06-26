package com.example.core.service.auth;

import com.example.common.domain.exception.ResourceAlreadyExistsException;
import com.example.common.domain.model.Client;
import com.example.core.service.client.ClientService;
import com.example.core.web.dto.LoginRequestDto;
import com.example.core.web.dto.LoginResponseDto;
import com.example.core.web.security.jwt.JwtProperties;
import com.example.core.web.security.jwt.TokenType;
import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final ClientService clientService;
    private final TokenService tokenService;
    private final JwtProperties jwtProperties;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void register(Client client) {
        if(clientService.existsByUsername(client.getUsername())){
           throw new ResourceAlreadyExistsException();
        }
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientService.create(client);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto request) {
         authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
         LoginResponseDto responseDto = new LoginResponseDto();
         responseDto.setAccess(
                 tokenService.create(
                         TokenParameters.builder(
                                 request.getUsername(),
                                         TokenType.ACCESS.name(),
                                 jwtProperties.getAccess()
                                 )
                                 .build()
                 )
         );
         responseDto.setRefresh(
                 tokenService.create(
                         TokenParameters.builder(
                                         request.getUsername(),
                                 TokenType.REFRESH.name(),
                                 jwtProperties.getRefresh()
                                 )
                                 .build()
                 )
         );
         return responseDto;
    }
}
