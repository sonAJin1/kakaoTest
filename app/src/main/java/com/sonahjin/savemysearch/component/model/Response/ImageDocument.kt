package com.sonahjin.savemysearch.component.model.Response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ImageDocument constructor(

    val Idx : Int, // index
    @SerializedName("collection")
    val collection: String, // 컬렉션
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String, // 이미지 썸네일 URL
    @SerializedName("image_url")
    val imageUrl: String, // 이미지의 URL
    @SerializedName("width")
    val width: Int, // 이미지의 가로 크기
    @SerializedName("height")
    val height: Int, // 이미지의 세로 크기
    @SerializedName("display_sitename")
    val displaySitename: String, // 출처명
    @SerializedName("doc_url")
    val docUrl : String, // 문서 URL
    @SerializedName("datetime")
    val dateTime: String, // 이미지 등록일 ISO 8601. [YYYY]-[MM]-[DD]T[hh]:[mm]:[ss].000+[tz],

    val isBookmark : Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Idx)
        parcel.writeString(collection)
        parcel.writeString(thumbnailUrl)
        parcel.writeString(imageUrl)
        parcel.writeInt(width)
        parcel.writeInt(height)
        parcel.writeString(displaySitename)
        parcel.writeString(docUrl)
        parcel.writeString(dateTime)
        parcel.writeByte(if (isBookmark) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImageDocument> {
        override fun createFromParcel(parcel: Parcel): ImageDocument {
            return ImageDocument(parcel)
        }

        override fun newArray(size: Int): Array<ImageDocument?> {
            return arrayOfNulls(size)
        }
    }
}