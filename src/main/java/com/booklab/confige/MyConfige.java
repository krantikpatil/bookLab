package com.booklab.confige;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyConfige extends WebSecurityConfigurerAdapter{

	@Bean
	public UserDetailsService getUserDetailsService() {
		
		return new CustomUserDetailsService();
	}
	
	
	@Bean 
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(this.getUserDetailsService());
		authProvider.setPasswordEncoder(this.passwordEncoder());
		
		return authProvider;
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(daoAuthenticationProvider());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/**").permitAll().and().formLogin().loginPage("/signIn")
		.permitAll()
        .and()
        .logout()
        .permitAll();
		

		}	
}

//http.antMatcher("/**").authorizeRequests().antMatchers("/")
//.permitAll().anyRequest().authenticated().and()
//.oauth2Login();

//http.antMatcher("/**").authorizeRequests().antMatchers("/")
//.permitAll().and()
//
//.authorizeRequests().antMatchers("/googleProtect")
//.authenticated().and()
//.oauth2Login();
//