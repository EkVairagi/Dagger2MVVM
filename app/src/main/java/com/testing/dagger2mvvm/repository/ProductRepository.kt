package com.testing.dagger2mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.testing.dagger2mvvm.db.FakerDB
import com.testing.dagger2mvvm.models.Product
import com.testing.dagger2mvvm.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerAPI: FakerAPI,private val fakerDB: FakerDB) {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts() {
        val result = fakerAPI.getProducts()
        if (result.isSuccessful && result.body() != null) {

            fakerDB.getFakerDAO().addProducts(result.body()!!)

            _products.postValue(result.body())
        }
    }
}