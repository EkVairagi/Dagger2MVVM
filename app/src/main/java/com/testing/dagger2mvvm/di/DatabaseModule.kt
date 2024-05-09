package com.testing.dagger2mvvm.di

import android.content.Context
import androidx.room.Room
import com.testing.dagger2mvvm.db.FakerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFakerDB(context: Context): FakerDB {
        return Room.databaseBuilder(context,FakerDB::class.java,"FakerDB").build()
    }

}