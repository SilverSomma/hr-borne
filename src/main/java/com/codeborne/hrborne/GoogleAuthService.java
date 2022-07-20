package com.codeborne.hrborne;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.http.HttpRequest;

@Service
public class GoogleAuthService {
    public String googleAuthenticationRequest() throws MalformedURLException {

        UriComponentsBuilder uri = UriComponentsBuilder.newInstance();
        uri.scheme("https")
                .host("accounts.google.com")
                .path("/o/oauth2/auth")
                .query("scope=openid")
                .query("client_id=27040378069-ikfaqni1p3kjuu3chbnrado9snib2usi.apps.googleusercontent.com")
                .query("redirect_uri=http://localhost:8081/absences")
                .query("response_type=code");

        return uri.toUriString();

    }
}
