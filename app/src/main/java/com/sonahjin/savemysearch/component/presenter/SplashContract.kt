package com.sonahjin.savemysearch.component.presenter

import com.sonahjin.savemysearch.base.BasePresenter
import com.sonahjin.savemysearch.base.BaseView

interface SplashContract{

    interface View : BaseView<Presenter> {

        fun moveToMain()

        fun showErrorAlert()
    }

    interface Presenter : BasePresenter {

    }

}