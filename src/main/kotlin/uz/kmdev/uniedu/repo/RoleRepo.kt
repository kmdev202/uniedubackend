package uz.kmdev.uniedu.repo

import org.springframework.data.jpa.repository.JpaRepository
import uz.kmdev.uniedu.model.security.Role

interface RoleRepo : JpaRepository<Role, Int> {
    fun findByName(name: String): Role?
}
