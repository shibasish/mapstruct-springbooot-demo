package com.example.demo

import com.fasterxml.jackson.annotation.JsonFormat
//import org.springframework.data.annotation.CreatedDate
//import org.springframework.data.annotation.Id
//import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant

open class BaseDocument {
//    @Id
    var id: String = "";

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
//    @LastModifiedDate
    var lastModifiedDate: Instant? = null

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
//    @CreatedDate
    var createdDate: Instant? = null
}