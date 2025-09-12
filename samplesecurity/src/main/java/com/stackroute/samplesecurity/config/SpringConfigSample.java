package com.stackroute.samplesecurity.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringConfigSample {
	
	@Bean
	public PasswordEncoder getencoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService users(PasswordEncoder encoder) {
		
 		UserDetails user = User.builder()
			.username("Mary")
			.password(encoder.encode("password"))
			.roles("MANAGER","USER")
			.build();
		UserDetails admin = User.builder()
			.username("Virat")
			.password(encoder.encode("pass123"))
			.roles("ADMIN","MANAGER")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
//	@Bean
// public SecurityFilterChain getfilter(HttpSecurity httpsecurity) throws Exception
//  {
//
//	return	httpsecurity.authorizeHttpRequests()
//		.requestMatchers("/banking/about").permitAll()
//		.and()
//		.authorizeHttpRequests()
//		.requestMatchers("/banking/user/**")
//		.authenticated()
//		.and()
//		.formLogin()
//		.and()
//		 .build();
//		
//		
// }
//	
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests((auth) -> auth
                .requestMatchers("/banking/about").permitAll() // public routes
                .requestMatchers("/banking/user/**").hasRole("ADMIN")           // admin-only
                .requestMatchers("/banking/api/**").hasAnyRole("MANAGER", "ADMIN") // devs and admins
                
                .anyRequest().authenticated() // all others require login
            )
//            .formLogin((form) -> form
//                .loginPage("/login")
//                .permitAll()
//            )
            .formLogin(Customizer.withDefaults())
            .logout((logout) -> logout.permitAll());

        return http.build();
    }
    
	
}
