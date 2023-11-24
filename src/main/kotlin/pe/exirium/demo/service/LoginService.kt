package pe.exirium.demo.service

import org.springframework.stereotype.Service
import pe.exirium.demo.dto.LoginDTO
import pe.exirium.demo.exception.UserNotFoundException
import pe.exirium.demo.repository.UserRepository
import pe.exirium.demo.response.LoginResponse

@Service
class LoginService(val userRepository: UserRepository) {

    fun login(loginDTO: LoginDTO): LoginResponse {
        return if (validateUser(loginDTO)) {
            LoginResponse(
                "success",
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InVzZXJUZXN0MSIsInVzZXJfbmFtZSI6IlVzZXJAdGVzdCIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNTE2MjM5MDIyfQ.TIDaV45q1h4hjDmpHsLmG0HFOl5q3s4NupK_FlT8aEc"
            )
        } else {
            throw UserNotFoundException("User not found")
        }
    }

    private fun validateUser(loginDTO: LoginDTO): Boolean {
        val validatesUsers = listOf(
            LoginDTO("userTest1", "passTest1"), LoginDTO("User@test ", "TestPass_"), LoginDTO("user123&", "123456")
        )

        return validatesUsers.contains(loginDTO)
    }
}