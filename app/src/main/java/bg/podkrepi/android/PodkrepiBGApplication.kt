package bg.podkrepi.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class PodkrepiBGApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupCrashLogging()
    }

    private fun setupCrashLogging() {
        Timber.plant(Timber.DebugTree())
    }
}
