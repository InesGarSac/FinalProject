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

    private val _movieList = MutableLiveData <List<MovieModel>>()
    val movieList: LiveData<List<MovieModel>> get() = _movieList
    private val _errorMessage = MutableLiveData<String?>()

    fun updateFavorite(movie: MovieModel) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    makeFavoriteListUseCase.invoke(movie)
                }
            } catch (t: Throwable) {
                _errorMessage.value = "Error"
            }
        }
    }

    fun getFavoritesMoviesList(state: Int) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    makeFavoriteListUseCase.invoke(state)
                }
                _movieList.value = result
            } catch (t: Throwable) {
                _errorMessage.value = "Error"
            }
        }
    }
}

