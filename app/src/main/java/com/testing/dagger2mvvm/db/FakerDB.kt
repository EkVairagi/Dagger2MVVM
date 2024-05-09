package com.testing.dagger2mvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.testing.dagger2mvvm.models.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB : RoomDatabase() {

    abstract fun getFakerDAO():FakerDAO

}