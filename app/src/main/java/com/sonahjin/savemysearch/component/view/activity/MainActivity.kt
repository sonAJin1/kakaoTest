package com.sonahjin.savemysearch.component.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.sonahjin.savemysearch.R
import com.sonahjin.savemysearch.base.BaseActivity
import com.sonahjin.savemysearch.component.model.Response.ImageDocument
import com.sonahjin.savemysearch.component.model.Response.ImageMeta
import com.sonahjin.savemysearch.component.presenter.MainContract
import com.sonahjin.savemysearch.component.presenter.MainPresenter
import com.sonahjin.savemysearch.component.view.adapter.MainImageAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.support.annotation.NonNull
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.AdapterView


class MainActivity : BaseActivity(), MainContract.View {


    private lateinit var mPresenter: MainContract.Presenter
    private lateinit var mImageAdapter: MainImageAdapter

    private var mCurrentPage = 1
    private var mIsEnd = false
    private var mFilter :String = ""
    private var mKeyword = "kakao pay"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()


    }


    private fun init(){

        mFilter = getString(R.string.filter_recency)
        // Create the presenter
        mPresenter = MainPresenter(this)
        // Create the Adapter
        mImageAdapter = MainImageAdapter(this)

        setAdapter()
        selectSpinnerListener()
        setClickListener()

        mImageAdapter.removeAll()
        mPresenter.start()

        hideKeyboard()

    }


    override fun setPresenter(presenter: MainContract.Presenter) {
        mPresenter = checkNotNull(presenter)
    }


    override fun showNoResult() {
        ll_no_result.visibility = View.VISIBLE
    }

    override fun hideNoResult() {
        ll_no_result.visibility = View.GONE
    }

    override fun hideLoading() {
       hideProgress()
    }

    override fun showLoading() {
        showProgress()
    }




    private fun setClickListener(){
        btn_search.setOnClickListener {

            if(et_search.text.toString().isNotEmpty()){
                mKeyword = et_search.text.toString()
                mImageAdapter.removeAll()
                mCurrentPage = 1
                mPresenter.loadImageList(mKeyword,mFilter,mCurrentPage)
            }else{
                showToast("검색어가 입력되지 않았습니다.")
            }
        }

        ib_top.setOnClickListener{ rc_image.scrollToPosition(0) }
    }

    private fun setRecyclerViewListener(){


        rc_image.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(@NonNull recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = LinearLayoutManager::class.java.cast(recyclerView.layoutManager)
                val totalItemCount = layoutManager!!.itemCount
                val lastVisible = layoutManager.findLastCompletelyVisibleItemPosition()

                if (lastVisible >= totalItemCount - 1 && totalItemCount!=0 && !mIsEnd ) {
                    mCurrentPage += 1
                    mPresenter.loadImageList(mKeyword,mFilter,mCurrentPage)
                }else if(mIsEnd){
                    showToast("마지막 페이지입니다.")
                }
            }
        })


    }

    private fun setFilter(filter:String){
        when(filter){
            getString(R.string.filter_recency)-> this.mFilter = "recency"
            getString(R.string.filter_accuracy)-> this.mFilter = "accuracy"
        }
    }

    private fun selectSpinnerListener(){

        sp_filter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                setFilter(parent!!.selectedItem.toString())
            }
        }
    }


    override fun setPageInfo(imageMeta: ImageMeta) {
        this.mIsEnd = imageMeta.isEnd
    }



    override fun showImageList(images : List<ImageDocument>) {
        mImageAdapter.addAll(images)
    }


    override fun showImageDetail(image: ImageDocument) {
        val intent = Intent(this, ImageDetailActivity::class.java)
        intent.putExtra("imageObject",image)
        startActivity(intent)
    }


    private fun setAdapter(){

        mImageAdapter = MainImageAdapter(baseContext)

        val layoutManager = GridLayoutManager(baseContext,2)
        layoutManager.orientation = RecyclerView.VERTICAL

        rc_image.layoutManager = layoutManager
        rc_image.adapter = mImageAdapter

        mImageAdapter.setListener(object : MainImageAdapter.OnClickListener{
            override fun onSelectImage(item: ImageDocument) {
                showImageDetail(item)
            }

        })

        setRecyclerViewListener()

    }

    override fun showBookmark() {

    }




}
