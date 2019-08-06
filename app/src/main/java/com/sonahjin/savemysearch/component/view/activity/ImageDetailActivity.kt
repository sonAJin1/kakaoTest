package com.sonahjin.savemysearch.component.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sonahjin.savemysearch.R
import com.sonahjin.savemysearch.component.model.Response.ImageDocument
import com.sonahjin.savemysearch.utils.ImageLoad
import kotlinx.android.synthetic.main.activity_image_detail.*
import android.widget.TextView
import android.text.style.UnderlineSpan
import android.text.SpannableString
import android.net.Uri
import android.support.v7.app.AlertDialog
import com.sonahjin.savemysearch.base.BaseActivity
import android.R.id
import android.content.*


class ImageDetailActivity : BaseActivity() {

    var mDocUrl : String = ""
    var mImageUrl : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        setListener()

        if(intent.hasExtra("imageObject")){
            var imageDetail = intent.getParcelableExtra<ImageDocument>("imageObject")
            showDetail(imageDetail)
            mDocUrl = imageDetail.docUrl
            mImageUrl = imageDetail.imageUrl

        }else{
            // intent 데이터가 없는 경우
            Toast.makeText(baseContext,"요청한 데이터가 없습니다. \n다시 시도해주세요.",Toast.LENGTH_LONG).show()
        }
    }


    private fun showDetail(imageObject : ImageDocument){

        ImageLoad().setImageResource(iv_background,imageObject.imageUrl,this.getDrawable(R.drawable.placeholder))
        tv_collection.text = imageObject.collection
        tv_sitename.text = imageObject.displaySitename

        //밑줄
       val content = SpannableString(imageObject.docUrl)
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        tv_doc_url.text = content
        tv_date.text = imageObject.dateTime

    }

    private fun setListener(){
        ib_cancel.setOnClickListener { finish() }
        tv_doc_url.setOnClickListener { moveToWebView() }

        ib_more.setOnClickListener {
            val info = arrayOf<CharSequence>("이미지 URL 저장", "페이지 링크로 이동")
            val builder = AlertDialog.Builder(this)
            builder.setItems(info) { dialog, which ->
                when (which) {
                    0 ->{
                        //클립보드 사용 코드
                        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        val clipData = ClipData.newPlainText("imageUrl", mImageUrl) //클립보드에 ID라는 이름표로 id 값을 복사하여 저장
                        clipboardManager!!.primaryClip = clipData

                        //복사가 되었다면 토스트메시지 노출
                        showToast("이미지 URL이 복사되었습니다")

                    }
                    1 ->{moveToWebView()}
                }
                dialog.dismiss()
            }
            builder.show()

        }

    }

    private fun moveToWebView(){
        val url = mDocUrl
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
