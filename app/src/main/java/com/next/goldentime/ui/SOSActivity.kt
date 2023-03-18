package com.next.goldentime.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.next.goldentime.ui.screens.sos.SOSScreen
import com.next.goldentime.usecase.sos.SOSType

class SOSActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { SOSNavigation() }
    }
}

@Composable
private fun SOSNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SOSNavigation.SOS.route) {
        composable(SOSNavigation.SOS.route) { SOSScreen(type = SOSType.HEART) }
    }
}

private sealed class SOSNavigation(val route: String) {
    object SOS : SOSNavigation("sos")
}
