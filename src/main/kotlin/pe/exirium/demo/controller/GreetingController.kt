package pe.exirium.demo.controller

import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pe.exirium.demo.service.GreetingService

@RestController
@RequestMapping("/v1/greeting")
class GreetingController(val greetingService: GreetingService) {

    private companion object : KLogging()

    @GetMapping("/{name}")
    fun retrieveGreeting(@PathVariable("name") name: String): String {
        logger.info("Name is $name")
        return greetingService.retrieveGreeting(name)
    }
}