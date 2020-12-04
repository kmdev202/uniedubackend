package uz.kmdev.uniedu.exception

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

var logger: Logger = LogManager.getLogger("LoggedExceptions")

fun LoggedError(ex: RuntimeException): RuntimeException {
    println("EXCEPTION LOG: ${ex.javaClass.simpleName} with message: ${ex.message}")
    logger.error("EXCEPTION LOG: ${ex.javaClass.simpleName} with message: ${ex.message}")
    return ex
}

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
class InvalidCredentialsException : RuntimeException("Username or password is incorrect!")