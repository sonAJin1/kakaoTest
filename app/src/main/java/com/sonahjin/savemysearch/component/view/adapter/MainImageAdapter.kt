package com.sonahjin.savemysearch.component.view.adapter

import android.content.Context
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sonahjin.savemysearch.R
import com.sonahjin.savemysearch.component.model.Response.ImageDocument
import com.sonahjin.savemysearch.utils.ImageLoad
import com.sonahjin.savemysearch.utils.RecyclerAdapter
import kotlinx.android.synthetic.main.item_main_image.view.*
import java.util.*

class MainImageAdapter(private val context: Context): RecyclerAdapter<ImageDocument, MainImageAdapter.SetViewHolder>()  {

    private var listener: OnClickListener? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetViewHolder {
        return SetViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_image, parent, false))
    }


    override fun onBindViewHolder(holder: SetViewHolder, position: Int) {

        var item = getItem(position)!!
        ImageLoad().setImageResource(holder.ivImg,item.imageUrl,context.getDrawable(R.drawable.placeholder))

        holder.itemView.setOnClickListener { listener!!.onSelectImage(item)}

    }

    fun setListener(listener: OnClickListener) {
        this.listener = listener
    }

    interface OnClickListener {
        fun onSelectImage(item : ImageDocument)
    }



    class SetViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val ivImg = view.iv_img
    }
}