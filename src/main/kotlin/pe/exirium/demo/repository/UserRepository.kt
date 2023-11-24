package pe.exirium.demo.repository

import org.springframework.data.repository.CrudRepository
import pe.exirium.demo.entity.User

interface UserRepository : CrudRepository<User, Int>