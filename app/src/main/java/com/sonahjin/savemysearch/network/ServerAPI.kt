package com.sonahjin.savemysearch.network

import com.sonahjin.savemysearch.component.model.Response.ImageResponse
import com.sonahjin.savemysearch.utils.Constants
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface ServerAPI {

    /**
     * sort 방식 설정해서 받아오는 부분 추가
     * page 값 어디에 저장할 건지? (adapter에 저장해둔 후에 요청할 때 꺼내올건지, activity에 저장해둘건지)
     */

    @Headers("Authorization: KakaoAK "+Constants.KAKAO_KEY)
    @GET("v2/search/image")
    fun getImageSearchList(
        @Query("query") keyword: String,
        @Query("sort") sort: String = "recency",
        @Query("page") page: Int,
        @Query("size") size: Int
    ) : Call<ImageResponse>

}