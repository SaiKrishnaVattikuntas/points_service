package com.krishna.points.controller;

import com.krishna.adapter.UserServiceAdapter;
import com.krishna.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/points", produces = MediaType.APPLICATION_JSON_VALUE)
public class PointsController {

    private final UserServiceAdapter userServiceAdapter;
    private final TokenService tokenService;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addPoints(){
      return userServiceAdapter.getUserService("Bearer " + tokenService.getAccessToken());
    }

    @GetMapping(value = "/add")
    public ResponseEntity<String> getPoints(){
        return ResponseEntity.ok("Points Fetched Successfully..");
    }
}
