package com.nhoclahola.bt_2511_springsecurityjwt_jwt.services;

import com.nhoclahola.bt_2511_springsecurityjwt_jwt.entities.User;
import com.nhoclahola.bt_2511_springsecurityjwt_jwt.models.LoginUserModel;
import com.nhoclahola.bt_2511_springsecurityjwt_jwt.models.RegisterUserModel;
import com.nhoclahola.bt_2511_springsecurityjwt_jwt.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signUp(RegisterUserModel input)
    {
        User user = User.builder()
                .fullName(input.getFullName())
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();
        return userRepository.save(user);
    }

    public User authenticate(LoginUserModel input)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword())
        );
        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }
}
