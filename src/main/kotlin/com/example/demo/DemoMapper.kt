package com.example.demo

import org.mapstruct.Mapper
import org.mapstruct.MappingConstants.ComponentModel.SPRING
import org.mapstruct.Mappings

@Mapper(componentModel = SPRING)
interface DemoMapper {

    fun personDocumentToPersonDto(personDocument: PersonDocument): PersonDto

    fun personDtoTOPersonDocument(personDto: PersonDto): PersonDocument
}