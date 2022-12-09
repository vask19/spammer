package com.example.spammer.service;
import com.example.spammer.model.User;
import com.example.spammer.repository.UserRepository;
import com.example.spammer.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    private  final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.of(new User()); //userRepository.findFirstByUsername(username);
        if (user.isEmpty())
            throw new UsernameNotFoundException("User not found");
        return new CustomUserDetails(user.get());

    }
}
