package kr.co.sh.spring_security6_jwt.service.user;

import java.util.HashSet;
import java.util.Set;
import kr.co.sh.spring_security6_jwt.config.JwtService;
import kr.co.sh.spring_security6_jwt.controller.user.dto.AuthenticationResponse;
import kr.co.sh.spring_security6_jwt.entity.roles.Role;
import kr.co.sh.spring_security6_jwt.entity.roles.Role.RoleType;
import kr.co.sh.spring_security6_jwt.entity.users.User;
import kr.co.sh.spring_security6_jwt.entity.users.UserRole;
import kr.co.sh.spring_security6_jwt.entity.users.repository.UserRepository;
import kr.co.sh.spring_security6_jwt.entity.users.repository.UserRoleRepository;
import kr.co.sh.spring_security6_jwt.exceptions.UserNotFoundException;
import kr.co.sh.spring_security6_jwt.service.user.dto.UserLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(String email, String password){
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(email, encodedPassword);
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, new Role(RoleType.ROLE_USER)));

        user = userRepository.save(user);
        userRoleRepository.saveAll(userRoles);
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(UserLoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        User user = userRepository.findByEmail(request.email())
            .orElseThrow(()-> new UserNotFoundException("User Not Found"));
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}
