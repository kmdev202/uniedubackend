package uz.kmdev.uniedu.model.base

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long = 0

    @JsonIgnore
    var deleted: Boolean = false

    @JsonIgnore
    var createdBy: String? = null
    var created: Date? = null
    @JsonIgnore
    var modifiedBy: String? = null
    @JsonIgnore
    var modified: Date? = null

    @PrePersist
    fun onPrePersist() {
        audit()
    }

    @PreUpdate
    fun onPreUpdate() {
        audit()
    }

    @PreRemove
    fun onPreRemove() {
        audit()
    }

    private fun audit() {
        if (id == 0L) {
            created = (Date())
        }
        modified = (Date())
    }
}