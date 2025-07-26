package com.krishna.adapter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "userserviceadapter", url = "${adapter.userServiceURL}")
public interface UserServiceAdapter {

    @GetMapping(value = "/api/users/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUserService(@RequestHeader("Authorization") String authorization);

}
