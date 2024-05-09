package com.testing.dagger2mvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.testing.dagger2mvvm.models.Product

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<Product>)

    @Query(value = "SELECT * FROM Product")
    suspend fun getProducts(): List<Product>
}