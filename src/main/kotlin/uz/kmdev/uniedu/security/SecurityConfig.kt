package uz.kmdev.uniedu.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import uz.kmdev.uniedu.constant.Roles
import uz.kmdev.uniedu.constant.Urls.API_PATH_PREFIX


@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private val customAuthProvider: CustomAuthenticationProvider? = null

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                //REST
                .antMatchers("/$API_PATH_PREFIX/signin").permitAll()
                .antMatchers("/$API_PATH_PREFIX/user/admin").hasAnyRole(Roles.ADMIN.toString())
                .anyRequest().authenticated()
                .and()
                .authenticationProvider(customAuthProvider)
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Bean
    fun encoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }


}
