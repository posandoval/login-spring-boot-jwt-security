package com.posandoval.demojwtmysql.Auth;

import com.posandoval.demojwtmysql.User.User;
import com.posandoval.demojwtmysql.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;
    @PostMapping(value="login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping(value="register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @GetMapping(value="test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Test Exitoso");
    }

    @GetMapping(value = "getUser/{name}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable String name){
        Optional<User> userTemp=userRepository.findByUsername(name);
        return ResponseEntity.ok(userTemp);
    }

}
