package uz.kmdev.uniedu.model.security

import javax.persistence.*


@Entity
@Table(name = "role")
class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    var roleId: Int = 0

    lateinit var name: String

    @ManyToMany(mappedBy = "roles")
    var users: Collection<User>? = null

    constructor() : super()

    constructor(name: String) : super() {
        this.name = name
    }


}
