package com.ganam.billion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusCheckController {

    @GetMapping("/fail")
    public ResponseEntity<String> serverStatusCheck() {
        return ResponseEntity.ok("실패다 이자식아 분발해라");
    }

    @GetMapping("/success")
    public ResponseEntity<String> serverStatusSuccess() {return ResponseEntity.ok("로그인 성공!!");}
}
