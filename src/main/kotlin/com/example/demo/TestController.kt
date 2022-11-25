package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.util.*
import javax.annotation.security.RolesAllowed

@RestController
@RequestMapping("/v1/accounts")
class TestController(private val demoMapper: DemoMapper) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun listAll(): List<PersonDto> {
        demoMapper.personDtoTOPersonDocument(
            PersonDto(
            email = "",
            first_name = "",
            last_name = "",
            dob = LocalDate.now()
        ))
        return Collections.emptyList()
    }
}