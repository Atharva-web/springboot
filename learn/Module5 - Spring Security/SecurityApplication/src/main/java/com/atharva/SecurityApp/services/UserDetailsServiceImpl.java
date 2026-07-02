package com.atharva.SecurityApp.services;

import com.atharva.SecurityApp.entities.UserEntity;
import com.atharva.SecurityApp.exceptions.ResourceNotFoundException;
import com.atharva.SecurityApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("inside loadUserByUsername");
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("user with email " + username + " not found"));
    }
}
