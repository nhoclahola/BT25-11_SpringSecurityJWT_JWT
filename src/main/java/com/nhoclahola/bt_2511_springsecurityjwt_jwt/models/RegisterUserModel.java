package com.nhoclahola.bt_2511_springsecurityjwt_jwt.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserModel
{
    private String email;
    private String password;
    private String fullName;
}
