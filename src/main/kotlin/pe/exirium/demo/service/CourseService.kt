package pe.exirium.demo.service

import org.springframework.stereotype.Service
import pe.exirium.demo.dto.CourseDTO
import pe.exirium.demo.exception.CourseNotFoundException
import pe.exirium.demo.repository.CourseRepository

@Service
class CourseService(val courseRepository: CourseRepository) {

    fun addCourse(courseDTO: CourseDTO): CourseDTO {
        val course = courseDTO.toEntity()
        courseRepository.save(course)
        return course.toDTO()
    }

    fun retrieveCourses(): List<CourseDTO> {
        return courseRepository.findAll().map { it.toDTO() }
    }

    fun updateCourse(id: Int, courseDTO: CourseDTO): CourseDTO {
        val course = courseRepository.findById(id).orElseThrow { CourseNotFoundException("Course not found") }
        courseRepository.save(course.copy(name = courseDTO.name, category = courseDTO.category))
        return course.toDTO()
    }
}