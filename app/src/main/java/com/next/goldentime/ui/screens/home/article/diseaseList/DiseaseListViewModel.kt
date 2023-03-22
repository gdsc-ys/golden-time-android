package com.next.goldentime.ui.screens.home.article.diseaseList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.next.goldentime.usecase.article.ArticleUseCase
import com.next.goldentime.util.generateArticleUseCase

class DiseaseListViewModel(
    private val articleUseCase: ArticleUseCase = generateArticleUseCase()
) : ViewModel() {
    private val _diseases = articleUseCase.listDiseases()

    val diseases = _diseases.asLiveData()
}