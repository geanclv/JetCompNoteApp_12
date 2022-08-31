package com.geancarloleiva.jetcompnoteapp_12.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//This class is used to add bindings to hilt: to tell hilt how to provide instances of different types
@InstallIn(SingletonComponent::class)
@Module
object AppModule {
}