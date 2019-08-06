package com.sonahjin.savemysearch.component.view.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.ContextThemeWrapper
import com.sonahjin.savemysearch.R
import com.sonahjin.savemysearch.base.BaseActivity
import com.sonahjin.savemysearch.component.presenter.SplashContract
import com.sonahjin.savemysearch.component.presenter.SplashPresenter
import com.sonahjin.savemysearch.network.ConnectivityHelper
import android.view.WindowManager


class SplashActivity : BaseActivity(), SplashContract.View {


    private lateinit var mPresenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        checkNetwork()
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        // Create the presenter
        mPresenter = SplashPresenter(this)

    }

    override fun setPresenter(presenter: SplashContract.Presenter) {
        mPresenter = checkNotNull(presenter)
    }


    private fun checkNetwork(){
        if (ConnectivityHelper.isConnectedToNetwork(this)) {

            Handler().postDelayed({
                moveToMain()
            }, 2000)


        } else {
            showErrorAlert()

        }
    }


    override fun moveToMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }



    override fun showErrorAlert() {
        val builder = AlertDialog.Builder(ContextThemeWrapper(this, R.style.Theme_AppCompat_Light_Dialog))
        builder.setTitle("네트워크 연결 오류")
        builder.setMessage("인터넷 연결이 원활하지 않아 접속이 종료됩니다.")

        builder.setPositiveButton("확인") { _, _ ->
            finish()
        }

        builder.show()
    }


}
