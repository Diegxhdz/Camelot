package com.example.clientes_venta.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.clientes_venta.Usuario.Rol;
import com.example.clientes_venta.Usuario.UsuarioService;

import lombok.AllArgsConstructor;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig{

    @Autowired
    private final UsuarioService usuarioService;

    @Bean
    public UserDetailsService UserDetailsService(){
        return usuarioService;
    }

    @Bean 
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(UserDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        return httpSecurity
            .csrf(csrf -> csrf.ignoringRequestMatchers("/req/signup"))
            .formLogin(httpForm -> {
                httpForm.loginPage("/login").permitAll();
                httpForm.defaultSuccessUrl("/home");
            })
            .authorizeHttpRequests(registry -> {
                registry.requestMatchers("/req/signup").permitAll();
                registry.requestMatchers("/admin/**").hasRole(Rol.ADMIN.name());
                registry.requestMatchers(HttpMethod.GET, "/admin/**").hasAuthority("admin:read");
                registry.requestMatchers(HttpMethod.POST, "/admin/**").hasAuthority("admin:create");
                registry.requestMatchers(HttpMethod.DELETE, "/admin/**").hasAuthority("admin:delete");
                registry.requestMatchers(HttpMethod.PUT, "/admin/**").hasAuthority("admin:update");
                registry.anyRequest().authenticated();
            })
            .build();
    }
}
