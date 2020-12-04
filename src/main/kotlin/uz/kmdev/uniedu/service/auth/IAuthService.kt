package uz.kmdev.uniedu.service.auth

import uz.kmdev.uniedu.model.security.User

interface IAuthService {
    fun signInUser(username: String, password: String) : User
}