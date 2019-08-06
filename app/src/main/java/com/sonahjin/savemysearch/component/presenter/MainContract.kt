package com.sonahjin.savemysearch.component.presenter

import android.content.Context
import com.sonahjin.savemysearch.base.BasePresenter
import com.sonahjin.savemysearch.base.BaseView
import com.sonahjin.savemysearch.component.model.Response.ImageDocument
import com.sonahjin.savemysearch.component.model.Response.ImageMeta

interface MainContract {
    interface View : BaseView<Presenter> {

        fun showImageList(imageList : List<ImageDocument>)

        fun showImageDetail(image: ImageDocument)

        fun showBookmark()

        fun setPageInfo(imageMeta: ImageMeta)

        fun showNoResult()

        fun hideNoResult()

        fun showLoading()

        fun hideLoading()

    }

    interface Presenter : BasePresenter {

        fun loadImageList(keyword:String, sort:String, page:Int)
    }
}