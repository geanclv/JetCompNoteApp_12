package com.geancarloleiva.jetcompnoteapp_12.di

import android.content.Context
import androidx.room.Room
import com.geancarloleiva.jetcompnoteapp_12.data.NoteDatabase
import com.geancarloleiva.jetcompnoteapp_12.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//This class is used to add bindings to hilt: to tell hilt how to provide instances of different types
@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase): NoteDatabaseDao {
        return noteDatabase.noteDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "tbl_note"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}