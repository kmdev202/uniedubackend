package uz.kmdev.uniedu.dto

import uz.kmdev.uniedu.model.security.User

data class SignInDTO (
    val username: String,
    val password: String
)

data class SignInResponseDTO (
    var token: String,
    var user_info: UserInfoDTO
)

class UserInfoDTO {
    var id: Long? = null
    var username: String? = null
    var firstname: String? = null
    var lastname: String? = null
    var roles: List<String> = arrayListOf()

    fun toDTO(user: User): UserInfoDTO {
        this.id = user.id
        this.username = user.username
        this.firstname = user.firstname
        this.lastname = user.lastname
        this.roles = user.roles.map { it.name }
        return this
    }
}