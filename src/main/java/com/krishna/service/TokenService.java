package com.krishna.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TokenService {

    @Value("${adapter.tokenAccessURL}")
    private String tokenURL;
    @Value("${tokenAccess.clientId}")
    private String clientID;

    @Value("${tokenAccess.clientSecret}")
    private String clientSecret;

    @Value("${tokenAccess.audience}")
    private String audience;

    @Value("${tokenAccess.grantType}")
    private String grantType;

    public String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> map = new HashMap<>();
        map.put("client_id", clientID);
        map.put("client_secret", clientSecret);
        map.put("audience", audience);
        map.put("grant_type", grantType);
        HttpEntity httpEntity = new HttpEntity<>(map, httpHeaders);
        ResponseEntity responseEntity = restTemplate.exchange(tokenURL, HttpMethod.POST, httpEntity, Map.class);
        return Optional.ofNullable(responseEntity).filter(response -> response.getStatusCode() == HttpStatus.OK).map(ResponseEntity::getBody).
                map(body -> ((Map<String, Object>) body).get("access_token")).map(Object::toString).
                orElseThrow(() -> new RuntimeException("Failed to Retrieve Access Token from Auth0 server"));
    }
}
