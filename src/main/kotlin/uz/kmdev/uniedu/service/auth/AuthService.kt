package uz.kmdev.uniedu.service.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import uz.kmdev.uniedu.model.security.User
import uz.kmdev.uniedu.repo.user.UserRepo

@Service
@Transactional
class AuthService @Autowired constructor(
        val userRepo: UserRepo
) : IAuthService {


    override fun signInUser(username: String, password: String): User {

        return User()
    }


}