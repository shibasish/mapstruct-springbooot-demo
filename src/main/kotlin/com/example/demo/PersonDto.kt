package com.example.demo

import java.time.LocalDate

data class PersonDto(
    var email: String,
    var first_name: String,
    var last_name: String,
    var dob: LocalDate,
    var address: AddressDto? = null
)
