package com.testing.dagger2mvvm

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.testing.dagger2mvvm.databinding.ActivityMainBinding
import com.testing.dagger2mvvm.viewmodels.MainViewModel
import com.testing.dagger2mvvm.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val products: TextView
        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as FakerApplication).applicationComponent.inject(this)

        val map = (application as FakerApplication).applicationComponent.getMap()

        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(
            MainViewModel::class.java
        )


        mainViewModel.productsLiveData.observe(this, Observer {
            products.text = it.joinToString { x -> x.title + "\n\n"}
        })

    }

}