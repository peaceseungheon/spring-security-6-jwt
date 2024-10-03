package kr.co.sh.spring_security6_jwt.controller.user;

import kr.co.sh.spring_security6_jwt.controller.user.dto.AuthenticationResponse;
import kr.co.sh.spring_security6_jwt.service.user.AuthenticationService;
import kr.co.sh.spring_security6_jwt.service.user.dto.UserLoginRequest;
import kr.co.sh.spring_security6_jwt.service.user.dto.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request.email(), request.password()));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody UserLoginRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
