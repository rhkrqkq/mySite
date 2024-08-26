package com.example.mySite.user;

import com.example.mySite.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.zip.DataFormatException;

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

    public AppUser getUser(String username) throws DataNotFoundException {
        Optional<AppUser> appUser = this.userRepository.findByUsername(username);
        if (appUser.isPresent()) {
            return appUser.get();
        } else {
            throw new DataNotFoundException("사용자를 찾을 수 없습니다.");
        }
    }
}
