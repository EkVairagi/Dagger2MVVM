package com.testing.dagger2mvvm.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testing.dagger2mvvm.models.Product
import com.testing.dagger2mvvm.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: ProductRepository,
    private val randomize: Randomize
) : ViewModel() {
    val productsLiveData: LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}

class Randomize @Inject constructor() {
    fun doAction() {
        Log.d("DaggerMVVM", "Random Action")
    }
}