package com.example.cqrsbankingapp.service.auth;

import com.example.cqrsbankingapp.domain.exception.ResourceAlreadyExistsException;
import com.example.cqrsbankingapp.domain.model.Client;
import com.example.cqrsbankingapp.service.client.ClientService;
import com.example.cqrsbankingapp.web.dto.LoginRequestDto;
import com.example.cqrsbankingapp.web.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final ClientService clientService;
    @Override
    public void register(Client client) {
        if(clientService.existsByUsername(client.getUsername())){
           throw new ResourceAlreadyExistsException();
        }
        //TODO has password
        client.setPassword(client.getPassword());
        clientService.create(client);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        //TODO
        return null;
    }
}
