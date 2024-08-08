package io.bintang.todo.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.bintang.todo.ui.home.HomeViewModel
import io.bintang.todo.ui.list.ListVoucherViewModel
import io.bintang.todo.util.ViewModelFactory
import io.bintang.todo.util.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun providesHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListVoucherViewModel::class)
    internal abstract fun providesListVoucherViewModel(viewModel: ListVoucherViewModel): ViewModel

}