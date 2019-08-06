package com.sonahjin.savemysearch.component.model.Response

import com.google.gson.annotations.SerializedName

data class ImageMeta(

    @SerializedName("total_count")
    val totalCount: Int, // 검색어에 검색된 문서수
    @SerializedName("pageable_count")
    val pageableCount: Int, // total_count 중에 노출가능 문서수
    @SerializedName("is_end")
    val isEnd: Boolean // 마지막 페이지인지 여부
)