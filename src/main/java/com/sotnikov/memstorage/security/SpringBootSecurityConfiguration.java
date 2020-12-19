package com.sotnikov.memstorage.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;


@Configuration
@EnableWebSecurity
public class SpringBootSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		  auth.inMemoryAuthentication()
//		  .withUser("root").password("{noop}password").roles("admin");
//	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http 
			.antMatcher("/admin/**")
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.anyRequest().authenticated()
			.and().formLogin();

	}
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .formLogin()
//                    .loginPage("/login")
//                    .failureUrl("/login?error")
//                    .and()
//                .authorizeRequests()
//                    .antMatchers("/tags").permitAll()
//                    .antMatchers("/admin/**").hasRole("ADMIN")
//                    .anyRequest().authenticated();
//    }
}
