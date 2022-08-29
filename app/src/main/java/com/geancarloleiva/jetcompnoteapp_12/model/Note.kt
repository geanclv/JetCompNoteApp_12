package com.geancarloleiva.jetcompnoteapp_12.model

import java.time.LocalDateTime
import java.util.*

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val detail: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
