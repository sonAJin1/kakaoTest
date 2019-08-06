package com.sonahjin.savemysearch.network

import com.sonahjin.savemysearch.BuildConfig
import com.sonahjin.savemysearch.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class RestClient {

    val BASE_URL = Constants.SERVER_URL
    private lateinit var serverApi: ServerAPI
    private val interceptor = HttpLoggingInterceptor()


    fun getApi() :ServerAPI {

        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client =  OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(100, TimeUnit.SECONDS).readTimeout(100, TimeUnit.SECONDS).build()
        val retrofitBuilder = Retrofit.Builder().baseUrl(BASE_URL)

        if(BuildConfig.DEBUG){
            retrofitBuilder.client(client)
        }
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create())
        val retrofit = retrofitBuilder.build()
        serverApi = retrofit.create(ServerAPI::class.java)


        return serverApi
    }


}