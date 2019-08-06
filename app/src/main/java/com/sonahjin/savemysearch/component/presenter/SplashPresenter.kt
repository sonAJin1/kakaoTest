package com.sonahjin.savemysearch.component.presenter

class SplashPresenter : SplashContract.Presenter{

    private var mLoginView: SplashContract.View

    constructor(miberView: SplashContract.View) {
        mLoginView = checkNotNull(miberView)
        mLoginView.setPresenter(this)
    }

    override fun start() {}


}