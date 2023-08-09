package com.keepcoding.finalproject.di

import android.content.Context
import androidx.room.Room
import com.keepcoding.finalproject.constants.URL
import com.keepcoding.finalproject.data.MovieRepository
import com.keepcoding.finalproject.data.MovieRepositoryImpl
import com.keepcoding.finalproject.data.local.LocalDataSource
import com.keepcoding.finalproject.data.local.LocalDataSourceImpl
import com.keepcoding.finalproject.data.local.MovieDao
import com.keepcoding.finalproject.data.local.MovieDatabase
import com.keepcoding.finalproject.data.remote.MovieApi
import com.keepcoding.finalproject.data.remote.RemoteDataSource
import com.keepcoding.finalproject.data.remote.RemoteDataSourceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(URL)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }


    single<MovieApi> {
        getMovieApi(get())
    }

    single {
        getDatabase(get())
    }

    single {
        providesMovieDao(get())
    }
}

private fun getMovieApi(retrofit: Retrofit) =
    retrofit.create(MovieApi::class.java)

private fun getDatabase(context: Context) : MovieDatabase =
    Room.databaseBuilder(
        context,
        MovieDatabase::class.java, "superhero-db"
    ).build()

private fun providesMovieDao(db: MovieDatabase) : MovieDao =
    db.movieDao()

