package pe.exirium.demo.dto

import jakarta.validation.constraints.NotBlank
import pe.exirium.demo.entity.Course

data class CourseDTO(
    val id: Int?,
    @get:NotBlank(message = "courseDTO.name must not be blank")
    val name: String,
    @get:NotBlank(message = "courseDTO.category must not be blank")
    val category: String
) {
    fun toEntity() = Course(
        id = null,
        name = name,
        category = category
    )
}