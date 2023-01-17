package com.saiful.myapplication.Worker

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.saiful.myapplication.MainApplication
import com.saiful.myapplication.R

class BlurWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
//        val appContext = applicationContext
        val appContext = MainApplication.applicationContext()

//        makeStatusNotification("Blurring image", appContext)

        return try {
            val picture = BitmapFactory.decodeResource(
                appContext.resources,
                R.drawable.android_cupcake)

//            val output = blurBitmap(picture, appContext)

            // Write bitmap to a temp file
//            val outputUri = writeBitmapToFile(appContext, output)

//            makeStatusNotification("Output is $outputUri", appContext)

            Result.success()
        } catch (throwable: Throwable) {
            Log.e("TAG", "Error applying blur")
            Result.failure()
        }
    }
}