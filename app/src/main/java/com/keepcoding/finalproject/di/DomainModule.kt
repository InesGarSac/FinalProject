package com.keepcoding.finalproject.di

import com.keepcoding.finalproject.domain.usecase.GetDetailUseCase
import com.keepcoding.finalproject.domain.usecase.GetMovieListUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetMovieListUseCase(get()) }
    single { GetDetailUseCase(get()) }
}
