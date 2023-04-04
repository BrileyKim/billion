package com.ganam.billion.controller;

import com.ganam.billion.dto.UserDto;
import com.ganam.billion.service.RegisterUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

    private RegisterUserService registerUserService;

    public AuthorizationController(RegisterUserService registerUserService){
        this.registerUserService = registerUserService;
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(UserDto dto){
        try{
            registerUserService.join(dto);
            return ResponseEntity.ok("join success");
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }


}
