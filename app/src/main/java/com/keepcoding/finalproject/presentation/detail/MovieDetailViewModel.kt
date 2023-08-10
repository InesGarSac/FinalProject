package com.keepcoding.finalproject.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.domain.usecase.GetDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel(
    private val getDetailUseCase: GetDetailUseCase
): ViewModel(){

    private val _movie = MutableLiveData<MovieModel>()
    val movie: LiveData<MovieModel> get() = _movie
    private val _errorMessage = MutableLiveData<String?>()

    fun getMovie(id: String) = viewModelScope.launch {
        try {
        val resultMovie = withContext(Dispatchers.IO){
            getDetailUseCase.invoke(id)
        }
        _movie.value = resultMovie
        } catch (_: Throwable) {
            _errorMessage.value = "Error lunched from ViewModel"
        }
    }
}