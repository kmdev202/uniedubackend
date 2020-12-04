package uz.kmdev.uniedu.model.security

import uz.kmdev.uniedu.model.base.BaseModel
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
class User : BaseModel() {

    @Column(name = "username")
    var username: String = ""

    @Column(name = "firstname")
    @Size(max = 100)
    var firstname: String? = null

    @Column(name = "lastname")
    @Size(max = 100)
    var lastname: String? = null

    @Column(name = "password")
    @Size(max = 100)
    var password: String? = null

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
            inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")])
    var roles: MutableList<Role> =  mutableListOf()

}
