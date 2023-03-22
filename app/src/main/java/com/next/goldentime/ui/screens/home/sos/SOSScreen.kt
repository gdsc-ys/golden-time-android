package com.next.goldentime.ui.screens.home.sos

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.next.goldentime.ui.components.common.Guide
import com.next.goldentime.ui.components.common.TopBar
import com.next.goldentime.ui.components.common.TopBarIcon
import com.next.goldentime.ui.components.home.WithTopBar
import com.next.goldentime.ui.components.home.sos.SOSTrigger

@Composable
fun SOSScreen(
    showAbout: () -> Unit,
    model: SOSViewModel = viewModel()
) {
    val context = LocalContext.current

    fun triggerSOS() {
        model.triggerSOS(context)
    }

    /**
     * Content
     */
    WithTopBar(
        topBar = {
            TopBar(
                "GOLDEN TIME",
                right = TopBarIcon(Icons.Outlined.Settings) { showAbout() }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SOSTrigger(triggerSOS = ::triggerSOS)
            Spacer(Modifier.height(40.dp))
            Guide(
                title = "SOS",
                description = "Press and hold the above button for 3\nseconds to make an emergency SOS."
            )
        }
    }
}