package com.nhoclahola.bt_2511_springsecurityjwt_jwt.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse
{
    private String token;
    private long expiresIn;
}
