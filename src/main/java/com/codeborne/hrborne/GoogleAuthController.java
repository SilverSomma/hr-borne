package com.codeborne.hrborne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;

@RestController
@RequestMapping("/login")
public class GoogleAuthController {

    @Resource
    GoogleAuthService googleAuthService;

    @GetMapping("/oauth")
    public String googleAuthenticationRequest() throws MalformedURLException {
        return googleAuthService.googleAuthenticationRequest();
    }


}
