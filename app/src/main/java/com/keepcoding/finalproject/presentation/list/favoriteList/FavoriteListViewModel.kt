package com.keepcoding.finalproject.presentation.list.favoriteList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.domain.usecase.MakeFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteListViewModel(
    private val makeFavoriteListUseCase: MakeFavoriteUseCase
): ViewModel() {

    private val _movie = MutableLiveData<MovieModel>()
    val movie: LiveData<MovieModel> get() = _movie

    fun updateFavorite(movie: MovieModel) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                makeFavoriteListUseCase.invoke(movie)
            }

        }
    }

}