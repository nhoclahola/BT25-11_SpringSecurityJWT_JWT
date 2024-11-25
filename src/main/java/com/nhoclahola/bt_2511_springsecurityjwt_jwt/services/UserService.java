package com.nhoclahola.bt_2511_springsecurityjwt_jwt.services;

import com.nhoclahola.bt_2511_springsecurityjwt_jwt.entities.User;
import com.nhoclahola.bt_2511_springsecurityjwt_jwt.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;

    public List<User> allUser()
    {
        return userRepository.findAll();
    }
}
