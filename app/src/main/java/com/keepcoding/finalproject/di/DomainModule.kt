package com.keepcoding.finalproject.di

import com.keepcoding.finalproject.domain.usecase.GetDetailUseCase
import com.keepcoding.finalproject.domain.usecase.GetFavoriteListUseCase
import com.keepcoding.finalproject.domain.usecase.GetMovieListUseCase
import com.keepcoding.finalproject.domain.usecase.MakeFavoriteUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetMovieListUseCase(get()) }
    single { GetDetailUseCase(get()) }
    single { GetFavoriteListUseCase(get()) }
    single { MakeFavoriteUseCase(get()) }
}
