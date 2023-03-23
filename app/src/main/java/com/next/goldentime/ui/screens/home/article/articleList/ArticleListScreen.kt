package com.next.goldentime.ui.screens.home.article.articleList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Emergency
import androidx.compose.material.icons.filled.IntegrationInstructions
import androidx.compose.material.icons.filled.MedicalInformation
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.next.goldentime.ui.components.common.TopBar
import com.next.goldentime.ui.components.home.WithTopBar
import com.next.goldentime.ui.components.home.article.ArticleItemData
import com.next.goldentime.ui.components.home.article.ArticleSection

@Composable
fun ArticleListScreen(
    showDiseaseList: () -> Unit,
    showCaseList: () -> Unit,
    model: ArticleListViewModel = viewModel()
) {
    /**
     * Content
     */
    WithTopBar(topBar = { TopBar("Articles") }) {
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp),
        ) {
            Text("Be ready to save life", fontSize = 28.sp, color = Color(0xFF9B4511))

            Spacer(Modifier.height(28.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                ArticleSection(
                    title = "Health Topics",
                    ArticleItemData(
                        title = "Emergency Cases",
                        description = "Emergency Cases",
                        icon = Icons.Filled.Emergency,
                        onClick = { showCaseList() }
                    ),
                    ArticleItemData(
                        title = "Diseases",
                        description = "Diseases",
                        icon = Icons.Filled.MedicalInformation,
                        onClick = { showDiseaseList() }
                    ),
                    ArticleItemData(
                        title = "Basic First-Aid Manual",
                        description = "Basic First-Aid Manual",
                        icon = Icons.Filled.MedicalServices,
                        onClick = { }
                    ),
                )
                ArticleSection(
                    title = "Get Started",
                    ArticleItemData(
                        title = "Onboarding",
                        description = "Onboarding",
                        icon = Icons.Filled.IntegrationInstructions,
                        onClick = { }
                    ),
                )
            }
        }
    }
}