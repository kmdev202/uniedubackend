package uz.kmdev.uniedu.util.user

import org.springframework.data.jpa.repository.JpaRepository
import uz.kmdev.uniedu.model.security.User

interface UserRepo : JpaRepository<User, Long> {
}