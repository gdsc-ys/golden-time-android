package com.next.goldentime.ui.screens.rescue.complete

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.next.goldentime.ui.components.common.TopBar
import com.next.goldentime.ui.screens.rescue.RescueViewModel

@Composable
fun RescueCompleteScreen(model: RescueViewModel) {
    Scaffold(topBar = { TopBar("All done") }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Completed")
        }
    }
}