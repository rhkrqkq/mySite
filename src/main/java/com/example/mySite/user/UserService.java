package com.example.mySite.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUser create(String username, String email, String password) {
        AppUser userEntity = new AppUser();
        userEntity.setUsername(username);
        userEntity.setEmail(email);
        userEntity.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(userEntity);
        return userEntity;
    }
}
