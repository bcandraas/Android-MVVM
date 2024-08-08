package io.bintang.todo.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.bintang.todo.ui.home.HomeFragment
import io.bintang.todo.ui.home.list.ListVoucherFragment


@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesListVoucherFragment(): ListVoucherFragment


}