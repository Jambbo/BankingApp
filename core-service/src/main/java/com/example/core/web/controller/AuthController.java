package com.example.core.web.controller;

import com.example.common.domain.model.Client;
import com.example.core.service.auth.AuthService;
import com.example.core.web.dto.ClientDto;
import com.example.core.web.dto.LoginRequestDto;
import com.example.core.web.dto.LoginResponseDto;
import com.example.core.web.dto.OnCreate;
import com.example.core.web.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;
    private final ClientMapper clientMapper;

    @GetMapping("/test")
    public String test() {
        log.info("KY");
        return "Test endpoint reached";
    }
    @PostMapping("/register")
    public void register(
            @RequestBody @Validated(OnCreate.class) final ClientDto clientDto
            ){
      log.info("register step is here");
        Client client = clientMapper.toEntity(clientDto);
        authService.register(client);
    }

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody @Validated final LoginRequestDto dto
    ){
        return authService.login(dto);
    }

}
