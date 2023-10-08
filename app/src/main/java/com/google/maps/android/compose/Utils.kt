package com.google.maps.android.compose

import android.app.ActionBar
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Build
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun LockScreenOrientation(orientation: Int) {
    val context = LocalContext.current
    DisposableEffect(orientation) {
        val activity = context.findActivity() ?: return@DisposableEffect onDispose {}
        val originalOrientation = activity.requestedOrientation
        activity.requestedOrientation = orientation
        onDispose {
            // restore original orientation when view disappears
            activity.requestedOrientation = originalOrientation
        }
    }
}

fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

@RequiresApi(Build.VERSION_CODES.R)
@androidx.media3.common.util.UnstableApi
@Composable
fun VideoPlay(onClose: () -> Unit) {
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = false
    systemUiController.isSystemBarsVisible = false
    systemUiController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

    val context = LocalContext.current
    val rawUri = Uri.parse("android.resource://${context.packageName}/${R.raw.opera}")
    Card(
        Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(15.dp))
        .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
        .background(Color.Transparent)
        .clip(RoundedCornerShape(15.dp))
        , elevation = 240.dp
    )

    {
        val exoPlayer = remember{
            ExoPlayer.Builder(context)
                .build()
                .apply {
                    val defaultDataSourceFactory = DefaultDataSource.Factory(context)
                    val dataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(
                        context,
                        defaultDataSourceFactory
                    )

                    val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                        .createMediaSource(MediaItem.fromUri(rawUri))

                    setMediaSource(source)
                    prepare()
                }
        }

        exoPlayer.playWhenReady = true
        exoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
        exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
        //WindowCompat.setDecorFitsSystemWindows(s, false)
//        actionBar!!.hide()
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
//            s.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
//        } else {
//            s.insetsController?.apply {
//                hide(WindowInsets.Type.statusBars())
//                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
//            }
//        }
        LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)



        DisposableEffect(
            AndroidView(factory = { PlayerView(context).apply {
//            hideController()
                useController = true
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                player = exoPlayer
                layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            }})
        )
        {
            onDispose { exoPlayer.release() }

        }
        BackHandler {

            onClose()
        }

    }
}
fun getResourceIdForCountryName(countryName: String, context: Context): Int {
    Log.d("country name", countryName)
    return context.resources.getIdentifier(countryName, "raw", context.packageName)
}
fun formatCountryName(countryName: String): String {
    // Convert to lowercase
    val lowercaseName = countryName.toLowerCase()

    // Remove spaces, special characters, and non-alphanumeric characters
    val formattedName = lowercaseName.replace(Regex("[^a-zA-Z0-9]"), "")


    return formattedName
}