package io.bintang.todo.di.module

import dagger.Module
import dagger.Provides
import io.bintang.todo.data.local.TodoDatabase
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCastDao(db: TodoDatabase) = db.todoDao()

}