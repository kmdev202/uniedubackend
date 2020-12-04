package uz.kmdev.uniedu.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uz.kmdev.uniedu.constant.Urls.API_PATH_PREFIX
import uz.kmdev.uniedu.dto.SignInDTO
import uz.kmdev.uniedu.dto.SignInResponseDTO
import uz.kmdev.uniedu.dto.UserInfoDTO
import uz.kmdev.uniedu.service.auth.IAuthService

@RestController
@RequestMapping("/$API_PATH_PREFIX")
class AuthenticationController {

    @Autowired
    lateinit var authService: IAuthService

    @PostMapping("/signin")
    @Throws(AuthenticationException::class)
    fun signIn(@RequestBody dto: SignInDTO): SignInResponseDTO {
        val user = authService.signInUser(dto.username, dto.password)
        val userInfo = UserInfoDTO().toDTO(user)
        val token = "testtoken"
        return SignInResponseDTO(token, userInfo)
    }

}