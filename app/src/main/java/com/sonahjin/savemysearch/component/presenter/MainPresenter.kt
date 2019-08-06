package com.sonahjin.savemysearch.component.presenter

import android.media.Image
import android.util.Log
import com.sonahjin.savemysearch.component.model.Response.ImageResponse
import com.sonahjin.savemysearch.network.RestClient
import com.sonahjin.savemysearch.utils.NetworkConstants
import javax.security.auth.callback.Callback

class MainPresenter : MainContract.Presenter {

    private var mMainView: MainContract.View


    constructor(mibersView: MainContract.View){
        mMainView = checkNotNull(mibersView)
        mMainView.setPresenter(this)
    }

    override fun start() {
        loadImageList("Kakao pay","recency",1)
    }

    override fun loadImageList(keyword:String, sort:String, page:Int) {

        mMainView.showLoading()

        RestClient().getApi()
            .getImageSearchList(keyword,sort,page,50).enqueue(object : Callback, retrofit2.Callback<ImageResponse> {

                override fun onResponse(call: retrofit2.Call<ImageResponse>, response: retrofit2.Response<ImageResponse>) {

                    if(response.code()== NetworkConstants.OK){
                        var imageResponse = response.body()
                        if(imageResponse!!.documents.isNotEmpty()){
                            mMainView.hideNoResult()
                            var imageList = imageResponse!!.documents
                            mMainView.showImageList(imageList)
                        }else{
                            mMainView.showNoResult()
                        }

                    }

                }
                override fun onFailure(call: retrofit2.Call<ImageResponse>, t: Throwable) {
                    Log.e("e: ",t.toString())
                }
            })

        mMainView.hideLoading()
    }
}