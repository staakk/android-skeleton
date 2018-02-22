package io.github.staakk.androidskeleton.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.staakk.androidskeleton.main.MainActivity
import io.github.staakk.androidskeleton.main.MainModule

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity

}
