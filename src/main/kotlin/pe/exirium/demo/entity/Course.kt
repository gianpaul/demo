package pe.exirium.demo.entity

import jakarta.persistence.*
import pe.exirium.demo.dto.CourseDTO

@Entity
@Table(name = "Courses")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    val name: String,
    val category: String
){
    fun toDTO() = CourseDTO(
        id = id,
        name = name,
        category = category
    )
}
