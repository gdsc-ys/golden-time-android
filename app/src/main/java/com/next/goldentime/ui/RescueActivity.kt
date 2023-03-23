package com.next.goldentime.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.next.goldentime.ui.screens.rescue.RescueScreen

class RescueActivity : ComponentActivity() {
    private val sosId by lazy { intent.getIntExtra("sosId", 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { RescueNavigation(sosId) }
    }
}

@Composable
private fun RescueNavigation(sosId: Int) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = RescueNavigation.Rescue.route) {
        composable(RescueNavigation.Rescue.route) { RescueScreen(sosId = sosId) }
    }
}

private sealed class RescueNavigation(val route: String) {
    object Rescue : RescueNavigation("rescue")
}
