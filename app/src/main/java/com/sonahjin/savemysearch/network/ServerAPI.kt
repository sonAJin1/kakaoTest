package com.sonahjin.savemysearch.network

import com.sonahjin.savemysearch.component.model.Response.ImageResponse
import com.sonahjin.savemysearch.utils.Constants
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface ServerAPI {


    @Headers("Authorization: KakaoAK "+Constants.KAKAO_KEY)
    @GET("v2/search/image")
    fun getImageSearchList(
        @Query("query") keyword: String,
        @Query("sort") sort: String = "recency",
        @Query("page") page: Int,
        @Query("size") size: Int
    ) : Call<ImageResponse>

}