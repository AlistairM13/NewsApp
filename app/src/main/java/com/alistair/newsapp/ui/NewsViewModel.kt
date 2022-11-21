package com.alistair.newsapp.ui

import androidx.lifecycle.ViewModel
import com.alistair.newsapp.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
): ViewModel() {

}