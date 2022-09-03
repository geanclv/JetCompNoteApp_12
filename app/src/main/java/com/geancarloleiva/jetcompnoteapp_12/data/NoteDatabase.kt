package com.geancarloleiva.jetcompnoteapp_12.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.geancarloleiva.jetcompnoteapp_12.model.Note
import com.geancarloleiva.jetcompnoteapp_12.util.DateConverter
import com.geancarloleiva.jetcompnoteapp_12.util.UUIDConverter

@Database(
    entities = [Note::class],
    version = 1, exportSchema = false
)
//Adding the TypeConverters (util classes) in order that Room can understand misunderstanding types
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {

    /*
    * Room configuration
    * 1. Define the entities (model classes) with @Entity
    * 2. Define Database (this class)
    * 3. Create Dao interface
    * 4. Create functions for our DB operations
    * */

    abstract fun noteDao(): NoteDatabaseDao
}