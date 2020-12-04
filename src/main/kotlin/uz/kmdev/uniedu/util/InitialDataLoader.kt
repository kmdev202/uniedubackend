package uz.kmdev.uniedu.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import uz.kmdev.uniedu.constant.Roles.*
import uz.kmdev.uniedu.model.security.Role
import uz.kmdev.uniedu.repo.RoleRepo
import javax.transaction.Transactional


@Component
class InitialDataLoader : ApplicationListener<ContextRefreshedEvent> {

    internal var alreadySetup = true

    @Autowired
    lateinit var roleRepo: RoleRepo


    @Transactional
    override fun onApplicationEvent(event: ContextRefreshedEvent) {

        if (alreadySetup)
            return


        createRoleIfNotFound(ADMIN.toString())
        createRoleIfNotFound(TEACHER.toString())
        createRoleIfNotFound(ANONYMOUS.toString())

        alreadySetup = true
    }


    @Transactional
    internal fun createRoleIfNotFound(name: String): Role {
        var role = roleRepo.findByName(name)
        if (role == null) {
            role = Role(name)
            roleRepo.save(role)
        }
        return role
    }
}