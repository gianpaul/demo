package pe.exirium.demo.repository

import org.springframework.data.repository.CrudRepository
import pe.exirium.demo.entity.Course

interface CourseRepository : CrudRepository<Course, Int>