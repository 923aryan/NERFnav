// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.maps.android.compose

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material3.Scaffold

import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.privacysandbox.tools.core.model.Type
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.maps.android.compose.ViewModel.RegisterViewModel

import com.google.maps.android.compose.theme.MapsComposeSampleTheme

private const val TAG = "MapSampleActivity"
@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        var ss = window
        var sd = actionBar
        super.onCreate(savedInstanceState)

        setContent {
//            window.insetsController?.apply {
//                hide(android.view.WindowInsets.Type.statusBars())
//            }

            MapsComposeSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = LocalContext.current

                    val viewModel : RegisterViewModel = viewModel()
                    val state by viewModel.fromActivity.collectAsState()
                    val see by remember{
                        mutableStateOf(state)
                    }
                    if(see)
                        Log.d("see", "haha")
//                    Column(
//                        Modifier
//                            .fillMaxSize(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Spacer(modifier = Modifier.padding(10.dp))
//                        Text(
//                            text = getString(R.string.main_activity_title),
//                            style = MaterialTheme.typography.h5
//                        )
//                        Spacer(modifier = Modifier.padding(10.dp))
//                        Button(
//                            onClick = {

//
//                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
//                    window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
//                } else {
//                    window.insetsController?.apply {
//                        hide(android.view.WindowInsets.Type.statusBars())
//                        systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
//                    }
//
//            }

                  // PopulationGraph(applicationContext = context)
//                    GDPGraph(context)

//
//                    Button(onClick = { s = true }, colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent)) {
//
//
//                    }
                        context.startActivity(Intent(context, BasicMapActivity::class.java))
//                    PopulationGraph(applicationContext = context)
//                    GDPGraph()
//                    context.startActivity(Intent(context, BasicMapActivity::class.java))
//                            }) {
//                            Text(getString(R.string.basic_map_activity))
//                        }
//                        Spacer(modifier = Modifier.padding(5.dp))
//                        Button(
//                            onClick = {
//                                context.startActivity(
//                                    Intent(
//                                        context,
//                                        MapInColumnActivity::class.java
//                                    )
//                                )
//                            }) {
//                            Text(getString(R.string.map_in_column_activity))
//                        }
//                        Spacer(modifier = Modifier.padding(5.dp))
//                        Button(
//                            onClick = {
//                                context.startActivity(
//                                    Intent(
//                                        context,
//                                        MapClusteringActivity::class.java
//                                    )
//                                )
//                            }) {
//                            Text(getString(R.string.map_clustering_activity))
//                        }
//                        Spacer(modifier = Modifier.padding(5.dp))
//                        Button(
//                            onClick = {
//                                context.startActivity(
//                                    Intent(
//                                        context,
//                                        LocationTrackingActivity::class.java
//                                    )
//                                )
//                            }) {
//                            Text(getString(R.string.location_tracking_activity))
//                        }
//                        Spacer(modifier = Modifier.padding(5.dp))
//                        Button(
//                            onClick = {
//                                context.startActivity(Intent(context, ScaleBarActivity::class.java))
//                            }) {
//                            Text(getString(R.string.scale_bar_activity))
//                        }
//                        Spacer(modifier = Modifier.padding(5.dp))
//                        Button(
//                            onClick = {
//                                context.startActivity(Intent(context, StreetViewActivity::class.java))
//                            }) {
//                            Text(getString(R.string.street_view))
//                        }
                }
                //}


            }

        }
    }
    }
//fun setStatusBarColor(
//    color: Color,
//    darkIcons: Boolean = color.luminance() > 0.5f,
//    transformColorForLightContent: (Color) -> Color = BlackScrimmed
//)