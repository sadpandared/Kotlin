package ua.kpi.its.lab.rest.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(inMemoryUserDetailsManager())
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic()
    }

    @Bean
    fun inMemoryUserDetailsManager(): UserDetailsService {
        val editor: UserDetails = User.builder()
            .username("editor")
            .password("{noop}password")
            .roles("EDITOR")
            .build()

        val viewer: UserDetails = User.builder()
            .username("viewer")
            .password("{noop}password")
            .roles("VIEWER")
            .build()

        return InMemoryUserDetailsManager(editor, viewer)
    }
}


class SecurityWebInitializer : AbstractSecurityWebApplicationInitializer()
