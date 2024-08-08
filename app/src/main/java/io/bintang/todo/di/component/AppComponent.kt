package io.bintang.todo.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import io.bintang.todo.TodoApp
import io.bintang.todo.di.module.ActivityBuilder
import io.bintang.todo.di.module.AppModule
import io.bintang.todo.di.module.NetworkModule
import io.bintang.todo.di.module.RepositoryModule
import io.bintang.todo.di.module.FragmentModule
import io.bintang.todo.di.module.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    AndroidInjectionModule::class,
    ActivityBuilder::class,
    FragmentModule::class,
    ViewModelModule::class])

interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TodoApp): Builder

        fun build(): AppComponent
    }

    fun inject(app: TodoApp)
}
