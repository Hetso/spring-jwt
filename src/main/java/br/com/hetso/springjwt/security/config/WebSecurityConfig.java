package br.com.hetso.springjwt.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.hetso.springjwt.security.jwt.JwtTokenAuthenticationFilter;
import br.com.hetso.springjwt.service.AuthenticationService;
import br.com.hetso.springjwt.utils.EncoderUtils;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(
    securedEnabled = true,
    jsr250Enabled = true,
    prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenAuthenticationFilter jwtFilter;
    private final AuthenticationService authService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // examples
                .antMatchers("/api/example/public").permitAll()
                .antMatchers("/api/example/authenticated").authenticated()
                .antMatchers("/api/example/manager").hasAnyAuthority("ADMIN", "MANAGER")
                .antMatchers("/api/example/**").hasAuthority("ADMIN")
                // default
                .antMatchers("/auth/signin").permitAll()
                .antMatchers("/api/**").authenticated();

        http.addFilterBefore(jwtFilter, 
                UsernamePasswordAuthenticationFilter.class);
    }

    @Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(authService)
				.passwordEncoder(EncoderUtils.getInstance());
	}

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
