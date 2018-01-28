package io.github.droidkaigi.confsched2018.presentation

import android.app.Activity
import android.content.Context
import com.tomoima.debot.strategy.DebotStrategy
import io.github.droidkaigi.confsched2018.util.CustomGlideApp
import kotlin.concurrent.thread

class ClearImageCacheDebotStrategy : DebotStrategy() {

    override fun startAction(activity: Activity) {
        clearImageCache(activity)
    }

    private fun clearImageCache(context: Context) {
        // call on UI thread
        CustomGlideApp.get(context).clearMemory()

        thread {
            // call on background thread
            CustomGlideApp.get(context).clearDiskCache()
        }
    }
}
