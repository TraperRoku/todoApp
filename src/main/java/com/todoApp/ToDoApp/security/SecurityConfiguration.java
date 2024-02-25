package com.todoApp.ToDoApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUser() {
        UserDetails user1 = createNewUser("Filip", "Filip123");
        UserDetails user2 = createNewUser("Zbychu", "Zbychu123");

        return new InMemoryUserDetailsManager(user1, user2);
    }

    public UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().authenticated()
                )
                .formLogin(login ->
                        login
                                .permitAll()
                );

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }
}
