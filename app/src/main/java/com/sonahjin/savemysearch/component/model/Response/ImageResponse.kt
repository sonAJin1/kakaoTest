package com.sonahjin.savemysearch.component.model.Response

import com.google.gson.annotations.SerializedName

data class ImageResponse (
    @SerializedName("meta")
    val meta: ImageMeta,

    @SerializedName("documents")
    val documents: List<ImageDocument>
)