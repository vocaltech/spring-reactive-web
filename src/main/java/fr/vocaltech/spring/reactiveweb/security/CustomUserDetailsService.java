package fr.vocaltech.spring.reactiveweb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.vocaltech.spring.reactiveweb.models.User;
import fr.vocaltech.spring.reactiveweb.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException(username);

        System.out.println("---> [CustomUserDetailsService.loadUserByUsername()] logged as: " + user.getUsername());
        System.out.println("---> [CustomUserDetailsService.loadUserByUsername()] roles: " + user.getRoles());

        return new CustomUserPrincipal(user);
    }
}
