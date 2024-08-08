package io.bintang.todo.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.bintang.todo.MainActivity

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}