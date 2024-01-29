package com.posandoval.demojwtmysql.Auth;

import com.posandoval.demojwtmysql.User.UserRepository;
import com.posandoval.demojwtmysql.jwt.JwtService;
import com.posandoval.demojwtmysql.User.Role;
import com.posandoval.demojwtmysql.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    //Contrucción del Registro
    public AuthResponse register(RegisterRequest registerRequest){

        //Construccion de User
        User user= User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .country(registerRequest.getCountry())
                .role(Role.USER)
                .build();

        //Save user in Repository
        userRepository.save(user);

        //Generate and return token
        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }
}
