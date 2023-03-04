package com.example.techeer.persistence.user.application;

import com.example.techeer.persistence.user.dao.UserRepository;
import com.example.techeer.persistence.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findByIdInner(Long id) {
        return userRepository.getById(id);
    }
}
