package pe.exirium.demo.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pe.exirium.demo.dto.LoginDTO
import pe.exirium.demo.service.LoginService

@RestController
@RequestMapping("/v1/login")
class LoginController(val loginService: LoginService) {

    @PostMapping
    fun login(@RequestBody loginDTO: LoginDTO) = loginService.login(loginDTO)
}