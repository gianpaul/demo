package pe.exirium.demo.dto

import pe.exirium.demo.entity.Course

data class CourseDTO(
    val id: Int?,
    val name: String,
    val category: String
) {
    fun toEntity() = Course(
        id = null,
        name = name,
        category = category
    )
}