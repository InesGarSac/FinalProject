package com.keepcoding.finalproject.di

import com.keepcoding.finalproject.presentation.detail.MovieDetailViewModel
import com.keepcoding.finalproject.presentation.list.favoriteList.FavoriteListViewModel
import com.keepcoding.finalproject.presentation.list.moviesList.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MovieListViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
    viewModel { FavoriteListViewModel(get()) }
}
