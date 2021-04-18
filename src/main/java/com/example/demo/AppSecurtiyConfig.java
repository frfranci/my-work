package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurtiyConfig extends WebSecurityConfigurerAdapter{

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		
//		List<UserDetails> user = new ArrayList<>();
//		
//		user.add(User.withDefaultPasswordEncoder().username("freely").password("freez").roles("user").build());
//		
//		return new InMemoryUserDetailsManager(user);
//	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public AuthenticationProvider AuthenticationProvider() {
		
		DaoAuthenticationProvider provder = new DaoAuthenticationProvider();
		provder.setUserDetailsService(userDetailsService);
 		provder.setPasswordEncoder(new BCryptPasswordEncoder());
		return provder;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/forgotPassword","/test-controller/path","/files/**", "/muneer", "/login", "/login-post", "/adserve/**","/adsclick/**","/load","/getad.video","/ezeads/api/**","/getad-api.img").anonymous()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.usernameParameter("username")
				.passwordParameter("password")
				.loginPage("/login")
				.defaultSuccessUrl("/", true)
				.failureUrl("/login?error=true")
				.and()
				.logout().logoutSuccessUrl("/login").deleteCookies("locationId").invalidateHttpSession(true).permitAll();
				http.headers().disable();//disabling header to check cross origin issue
						

	}

	
	
}
