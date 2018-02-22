package io.github.staakk.androidskeleton

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import com.jakewharton.threetenabp.AndroidThreeTen
import android.os.StrictMode
import com.squareup.leakcanary.LeakCanary
import io.github.staakk.androidskeleton.di.DaggerAppComponent


/**
 * Created by staakk on 22/02/18.
 */
class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        setupLeakCanary()
        enabledStrictMode()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {

        }
        AndroidThreeTen.init(this)

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
                .application(this)
                .build()
        appComponent.inject(this)
        return appComponent
    }

    private fun setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        enabledStrictMode()
        LeakCanary.install(this)
    }

    private fun enabledStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDeath()
                    .build())
        }
    }

}