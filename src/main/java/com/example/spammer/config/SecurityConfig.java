package com.example.spammer.config;

import com.example.spammer.security.CustomSimpleUrlAuthenticationSuccessHandler;
import com.example.spammer.service.CustomUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    private final CustomUserDetailsServiceImpl customUserDetailsService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((requests) -> {
                    try {
                        requests
                                .requestMatchers("/api/").permitAll()
                                .anyRequest()
                                .hasAnyRole("USER")

                                .and()
                                .userDetailsService(customUserDetailsService)
                                .formLogin()
                                .loginPage("/api/auth/login");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .csrf().disable()
//                .authorizeHttpRequests((requests) -> requests
//                        .antMatchers("/api/auth/**","/api/").permitAll()
//                        .antMatchers("/api/products").permitAll()
//                        .antMatchers("/api/images/{id}").permitAll()
//
//
//                        .antMatchers("/api/message/**").hasAnyRole("USER","ADMIN")
//                        .antMatchers("/api/emails/activation/**").hasRole("NOT_CONFIRMED_USER")
//                        .anyRequest()
//                        .hasAnyRole("USER", "ADMIN")
//                        .and()
//
//                )
//                .userDetailsService(customUserDetailsService)
//
//                .formLogin().loginPage("/api/auth/login")
//                    .loginProcessingUrl("/process_login")
//                    .defaultSuccessUrl("/api/",true)
//                .successHandler(customAuthenticationSuccessHandler())
//                    .failureUrl("/api/auth/login?error")
//                    .permitAll()
//                .and()
//                .logout(LogoutConfigurer::permitAll);
//
//        return http.build();
//    }

    @Bean
    public WebSecurityCustomizer ignoringCustomizer() {

        return (web)
                -> web.ignoring().requestMatchers("/resources/**")
                .and()
                .ignoring().requestMatchers("/Users/vasylkorol/IdeaProjects/ysellb-to-heroku/src/main/resources/templates/images/1.jpeg");
    }


    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler(){
        return new CustomSimpleUrlAuthenticationSuccessHandler();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}

