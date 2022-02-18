package es.iespuertodelacruz.josedavid.bibliotecaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.web.cors.CorsUtils;

import es.iespuertodelacruz.josedavid.bibliotecaapi.security.FiltroJWT;

@SpringBootApplication
public class BibliotecaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApiApplication.class, args);
	}
	
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	    @Override
	    public void configure(WebSecurity webSecurity) throws Exception
	    {
	        webSecurity
	            .ignoring()
	            .antMatchers(HttpMethod.POST, "/api/login")
	            //.antMatchers("/api/v2/**")
	            .antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**","/swagger-resources/configuration/ui","/swagger-ui.html")
	            
	            ;
	            //.antMatchers("/**");
	    }
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http 
	    	.addFilterBefore(new CustomCorsFilter(), WebAsyncManagerIntegrationFilter.class)
			.csrf().disable()
			.addFilterBefore(new FiltroJWT(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.requestMatchers(CorsUtils::isCorsRequest).permitAll()
			.antMatchers(HttpMethod.OPTIONS, "**").permitAll()
			.antMatchers("/api/v3/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			
			;	    
		
	    }
	}

}
