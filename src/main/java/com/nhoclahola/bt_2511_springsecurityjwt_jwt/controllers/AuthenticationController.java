package com.nhoclahola.bt_2511_springsecurityjwt_jwt.controllers;

import com.nhoclahola.bt_2511_springsecurityjwt_jwt.entities.User;
import com.nhoclahola.bt_2511_springsecurityjwt_jwt.models.LoginResponse;
import com.nhoclahola.bt_2511_springsecurityjwt_jwt.models.LoginUserModel;
import com.nhoclahola.bt_2511_springsecurityjwt_jwt.models.RegisterUserModel;
import com.nhoclahola.bt_2511_springsecurityjwt_jwt.services.AuthenticationService;
import com.nhoclahola.bt_2511_springsecurityjwt_jwt.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController
{
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService)
    {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity<User> register(@RequestBody RegisterUserModel registerUser)
    {
        User registerdUser = authenticationService.signUp(registerUser);
        return ResponseEntity.ok(registerdUser);
    }

    @PostMapping("/login")
    @Transactional
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserModel loginUser)
    {
        User authenticatedUser = authenticationService.authenticate(loginUser);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}
