package io.github.staakk.androidskeleton.di

import android.app.Application

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import io.github.staakk.androidskeleton.App

@Singleton
@Component(modules = [
    NetModule::class,
    ApplicationModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: App)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}
