package org.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	@Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer.antMatchers(HttpMethod.GET, "/tutorials","/custom").hasRole("EMPLOYEE").
				antMatchers(HttpMethod.GET, "/tutorials/**","/custom/**").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.POST, "/tutorials/**","/custom/**").hasRole("MANAGER")
				.antMatchers(HttpMethod.PATCH, "/tutorials/**","/custom/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/tutorials/**","/custom/**").hasRole("ADMIN"));
		http.httpBasic();
		http.cors().disable();
		http.csrf().disable();
		return http.build();
	}
}
