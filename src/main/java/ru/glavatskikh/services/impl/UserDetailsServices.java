package ru.glavatskikh.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.glavatskikh.model.User;
import ru.glavatskikh.repository.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServices implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        log.info("User found: {}", user);
        return user;
    }
}
