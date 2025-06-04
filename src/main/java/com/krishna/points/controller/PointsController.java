package com.krishna.points.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/points", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PointsController {

    @PostMapping(value = "/add")
    public ResponseEntity<String> addPoints(){
        return ResponseEntity.ok("Points Added Successfully..");
    }

    @GetMapping(value = "/add")
    public ResponseEntity<String> getPoints(){
        return ResponseEntity.ok("Points Fetched Successfully..");
    }
}
