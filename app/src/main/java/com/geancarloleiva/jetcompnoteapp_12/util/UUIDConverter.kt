package com.geancarloleiva.jetcompnoteapp_12.util

import androidx.room.TypeConverter
import java.util.*

class UUIDConverter {

    @TypeConverter
    fun stringFromUUID(uuid: UUID): String? {
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }
}