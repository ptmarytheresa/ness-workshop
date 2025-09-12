package com.stackroute.securitydb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.stackroute.securitydb.helper.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {
	
@Bean
	
	public PasswordEncoder getencoder()
	{
		return new BCryptPasswordEncoder();
	}
	

	
	@Bean
	public SecurityFilterChain getFilter(HttpSecurity http) throws Exception
	{
		
 
		
		http
		.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests((auth) -> auth
            .requestMatchers("/home/register").permitAll()
            .requestMatchers("/users/viewemployee").hasRole("MANAGER")
            .requestMatchers("/users/dashboard").hasRole("ADMIN")
            .anyRequest().authenticated()
        )
        .formLogin(Customizer.withDefaults()) // ADD THIS - enables default login page
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .deleteCookies("JSESSIONID")
            .permitAll()
        );
		
     //   .csrf().disable();
    
    return http.build();
	
	}
	
	@Bean
	public UserDetailsService getuserdetail()
	{
		return new UserDetailsServiceImpl();
	}
 
	@Bean
	public AuthenticationProvider authentication()
	{
		
		DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
		
		dao.setUserDetailsService(getuserdetail());
		dao.setPasswordEncoder(getencoder());
		return dao;
		
	}
	
	
	

}
