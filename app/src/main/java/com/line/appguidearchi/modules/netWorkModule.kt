package com.line.appguidearchi.modules

import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT = 15L
private const val WRITE_TIMEOUT = 15L
private const val READ_TIMEOUT = 15L

val networkModule = module {
    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }

    //  gson builder
    single { GsonBuilder().create() }

    // client
    single {
        OkHttpClient.Builder().apply {
            cache(get())
            connectTimeout(CONNECT_TIMEOUT , TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT , TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
        }
    }

    // retrofit
    single {
        Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(get())
            .client(get())
            .build()
    }

}