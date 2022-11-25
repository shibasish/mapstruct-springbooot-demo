package com.example.demo

import java.time.LocalDate

//@Document("persons")
data class PersonDocument(

//    @Indexed(unique = true)
    var email: String,

    var first_name: String,
    var last_name: String,
    var dob: LocalDate,
    var address: AddressDocument? = null

): BaseDocument()