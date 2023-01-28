package com.example.jetnote.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id : UUID = UUID.randomUUID(),
    val title : String ,
    val discription : String,
    val entryData : LocalDateTime= LocalDateTime.now()
)