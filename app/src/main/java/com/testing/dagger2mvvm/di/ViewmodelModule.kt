package com.testing.dagger2mvvm.di

import androidx.lifecycle.ViewModel
import com.testing.dagger2mvvm.viewmodels.MainViewModel
import com.testing.dagger2mvvm.viewmodels.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@InstallIn(SingletonComponent::class)
@Module
abstract class ViewmodelModule {

    //@StringKey("mainViewModel")
    @ClassKey(MainViewModel::class)
    @Binds
    @IntoMap
    abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel

    //@StringKey("mainViewModel2")
    @ClassKey(MainViewModel2::class)
    @Binds
    @IntoMap
    abstract fun mainViewModel2(mainViewModel: MainViewModel2): ViewModel

}