package domb.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import domb.app.security.filters.TokenAuthenticationFilter;
import domb.app.services.UserService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenAuthenticationFilter tokenAuthenticationFilter;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests().antMatchers("/auth/**").permitAll()
                                .antMatchers("/questions/**").permitAll()
                                .antMatchers("/sensor-values/**").permitAll()
                                .antMatchers("/diagnose/**").permitAll()                                
            .anyRequest().authenticated().and().cors().and()
            .addFilterBefore(tokenAuthenticationFilter, BasicAuthenticationFilter.class);

        http.csrf().disable();
        http.headers()
            .xssProtection()
            .and()
            .contentSecurityPolicy("script-src 'self'");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST, "/auth/login");
        web.ignoring().antMatchers(HttpMethod.POST, "/users/");
        web.ignoring().antMatchers(HttpMethod.GET, "/users/registrationConfirm");
        web.ignoring().antMatchers(HttpMethod.POST, "/users/resendVerificationToken");
    }

}