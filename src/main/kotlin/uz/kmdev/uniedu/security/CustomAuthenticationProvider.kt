package uz.kmdev.uniedu.security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.stereotype.Component
import uz.kmdev.uniedu.exception.InvalidCredentialsException
import uz.kmdev.uniedu.exception.LoggedError
import java.io.Serializable

@Component
class CustomAuthenticationProvider: AuthenticationProvider, Serializable {

    override fun authenticate(authentication: Authentication?): Authentication {
        if (authentication != null && authentication.principal != null && authentication.authorities != null && authentication.authorities.isNotEmpty()) {
            try {
                val username = authentication.principal.toString()
                val password = authentication.credentials.toString()
                return UsernamePasswordAuthenticationToken(
                        username,
                        password,
                        authentication.authorities
                )
            } catch (e: AuthenticationException) {
                throw LoggedError(InvalidCredentialsException())
            }
        } else if(authentication != null && authentication.principal != null) {
            try {
                val username = authentication.principal.toString()
                val password = authentication.credentials.toString()
                return UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
            } catch (e: AuthenticationException) {
                throw LoggedError(InvalidCredentialsException())
            }
        } else
            throw LoggedError(BadCredentialsException("Invalid token!"))
    }

    override fun supports(authentication: Class<out Any>): Boolean {
        return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
    }


}