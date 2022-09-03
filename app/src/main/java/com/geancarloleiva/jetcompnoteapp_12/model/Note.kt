package com.geancarloleiva.jetcompnoteapp_12.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "tbl_note") //Creates a table in SQLite
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name = "note_detail")
    val detail: String,
    @ColumnInfo(name = "entry_date", defaultValue = "(datetime('now'))")
    val entryDate: Date = Date.from(Instant.now())
    //val entryDate: String = LocalDateTime.now().toString() //not needed because the Date was fixed with the TypeConverter
)
