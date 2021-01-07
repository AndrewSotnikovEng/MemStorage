package com.sotnikov.memstorage.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.sotnikov.memstorage.repositories.MyUserDetailsService;


@Configuration
@EnableWebSecurity
public class SpringBootSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		  auth.inMemoryAuthentication()
//		  .withUser("root").password("{noop}password").roles("admin");
//	}
	
	@Autowired
    private MyUserDetailsService userDetailsService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http 
			.authorizeRequests()
			.antMatchers("/admin/**").authenticated()
			.antMatchers("/").permitAll()
			.and()
			.formLogin().loginPage("/login").permitAll();

	}
//	
   @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        
	   DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return authProvider;
    }
   
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
}
