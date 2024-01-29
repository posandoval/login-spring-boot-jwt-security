package com.posandoval.demojwtmysql.Auth;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    String username;
    String password;

}
