package pe.exirium.demo.service

import org.springframework.stereotype.Service
import pe.exirium.demo.dto.CourseDTO
import pe.exirium.demo.exception.CourseNotFoundException
import pe.exirium.demo.repository.CourseRepository

@Service
class CourseService(val courseRepository: CourseRepository) {

    fun addCourse(courseDTO: CourseDTO): CourseDTO {
        return courseRepository.save(courseDTO.toEntity()).toDTO()
    }

    fun retrieveCourses(): List<CourseDTO> {
        return courseRepository.findAll().map { it.toDTO() }
    }

    fun updateCourse(id: Int, courseDTO: CourseDTO): CourseDTO {
        val course = courseRepository.findById(id).orElseThrow { CourseNotFoundException("Course $id not found") }
        return courseRepository.save(course.copy(name = courseDTO.name, category = courseDTO.category)).toDTO()
    }

    fun deleteCourse(id: Int) {
        val course = courseRepository.findById(id).orElseThrow { CourseNotFoundException("Course $id not found") }
        courseRepository.delete(course)
    }
}