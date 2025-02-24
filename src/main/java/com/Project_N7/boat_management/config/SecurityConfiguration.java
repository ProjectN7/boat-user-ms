package com.Project_N7.boat_management.config;

import com.Project_N7.boat_management.filter.CorsConfig;
import com.Project_N7.boat_management.filter.JwtFilter;
import com.Project_N7.boat_management.service.UserService;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private CorsConfig corsConfig;

    @Autowired
    private JwtFilter jwtFilter;

    //Prendo user dal DB e creo il customer user object
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //userService prenderà lo userDetails dal DB e manderà le informazioni
        auth.userDetailsService(userService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /*
       STATELESS, is a guarantee that the application won't create any session at all.
       These more strict control mechanisms have the direct implication that cookies are not used,
       and so each and every request needs to be re-authenticated.
     */


    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests().antMatchers("/user/authenticate").permitAll().anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(corsConfig.corsFilter(), UsernamePasswordAuthenticationFilter.class);
    }
*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        // Enable CORS and disable CSRF
        http
                .cors().and().csrf().disable()
                .addFilterBefore(corsConfig.corsFilter(), UsernamePasswordAuthenticationFilter.class)
                // Set session management to stateless
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // Set unauthorized requests exception handler
                .exceptionHandling()
                .authenticationEntryPoint((request, response, ex) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
                })
                .and();

    }

}
