package com.alura.mvc.mudi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.anyRequest().authenticated()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/home", true)
				.permitAll()
			)
			.logout(logout -> logout                                                
	            .logoutUrl("/logout")
            );

		return http.build();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(16);
	}
	
	@Bean
	public UserDetailsManager users(PasswordEncoder encoder) {
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		return users;
	}
}
