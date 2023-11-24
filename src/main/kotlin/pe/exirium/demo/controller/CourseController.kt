package pe.exirium.demo.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pe.exirium.demo.dto.CourseDTO
import pe.exirium.demo.service.CourseService

@RestController
@RequestMapping("/v1/courses")
class CourseController(val courseService: CourseService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCourse(@RequestBody courseDTO: CourseDTO) = courseService.addCourse(courseDTO)

    @GetMapping
    fun retrieveCourses() = courseService.retrieveCourses()

    @PutMapping("/{id}")
    fun updateCourse(@RequestBody courseDTO: CourseDTO, @PathVariable id: Int) = courseService.updateCourse(id,courseDTO)
}