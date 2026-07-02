package com.atharva.SecurityApp.services;

import com.atharva.SecurityApp.dto.LoginDto;
import com.atharva.SecurityApp.dto.SignupDto;
import com.atharva.SecurityApp.dto.UserDto;
import com.atharva.SecurityApp.entities.UserEntity;
import com.atharva.SecurityApp.exceptions.ResourceNotFoundException;
import com.atharva.SecurityApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserDto signup(SignupDto signupDto) {
//        check if user is present
        UserDto userDto = null;
        try {
            Optional<UserEntity> checkUserPresent = userRepository.findByEmail(signupDto.getEmail());
            if(checkUserPresent.isPresent()) {
                throw new Exception("Exception: User with email " + signupDto.getEmail() + " already exists");
            }

            signupDto.setPassword(passwordEncoder.encode(signupDto.getPassword()));
            UserEntity userEntity = userRepository.save(modelMapper.map(signupDto, UserEntity.class));
            userDto = modelMapper.map(userEntity, UserDto.class);
        }
        catch (Exception exception) {
             System.out.println(exception.getMessage());
        }

        return userDto;
    }


    public String login(LoginDto loginDto) {
//        // I think, instead of manually checking if the user is present,
//        // just check if the request is able to log in
//        Optional<UserEntity> userEntity = userRepository.findByEmail(loginDto.getEmail());
//        if(userEntity.isPresent()) {
//            String password = userEntity.get().getPassword(); // one way hashed password
//            String inputPassword = loginDto.getPassword();
//            // encrypt this password
//            String encodedInputPassword = passwordEncoder.encode(inputPassword);
//            if(password != null && password.equals(encodedInputPassword)) {
//                // the request is authentic
//                // but, what do we return?
//            }
//        }

        System.out.println("sending email and password for auth");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

        System.out.println("Authenticated.");
        System.out.println("reading user entity");

        UserEntity userEntity = (UserEntity) authentication.getPrincipal();

        System.out.println("obtained the current user entity");
        return jwtService.generateToken(userEntity);
    }
}
