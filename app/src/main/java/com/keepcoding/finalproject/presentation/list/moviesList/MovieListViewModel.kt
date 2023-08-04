package com.keepcoding.finalproject.presentation.list.moviesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.finalproject.domain.model.MovieModel
import com.keepcoding.finalproject.domain.usecase.GetMovieListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {


    private val _movieList = MutableLiveData<List<MovieModel>>()
    val movieList: LiveData<List<MovieModel>> get() = _movieList

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    getMovieListUseCase.invoke()
                }
                _movieList.value = result
            } catch (t: Throwable) {/* TODO */}
        }
    }
}
