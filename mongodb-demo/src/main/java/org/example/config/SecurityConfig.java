/**package org.example.config;

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
	public InMemoryUserDetailsManager userDetailsManager() {

		UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();

		UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails susan = User.builder().username("susan").password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();

		return new InMemoryUserDetailsManager(john, mary, susan);
	}

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer.antMatchers(HttpMethod.GET, "/employees").hasRole("EMPLOYEE").
				antMatchers(HttpMethod.GET, "/employees/**").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.POST, "/employees/**").hasRole("MANAGER")
				.antMatchers(HttpMethod.PATCH, "/employees/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN"));
		http.httpBasic();
		http.cors().disable();
		http.csrf().disable();
		return http.build();
	}
}**/
