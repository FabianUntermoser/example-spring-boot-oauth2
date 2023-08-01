package com.example.examplespringbootpostgres;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration
{

    /**
     * Configures the {@link SecurityFilterChain}
     *
     * @param http The {@link HttpSecurity} to configure
     * @return The {@link SecurityFilterChain} created by the customized {@link HttpSecurity}
     * @throws Exception In case of any errors
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.csrf().disable();

        http.authorizeHttpRequests()
            .requestMatchers("/api/**")
            .permitAll()
            .anyRequest()
            .authenticated();

        http.oauth2Client();

        return http.build();
    }

}
