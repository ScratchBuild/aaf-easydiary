package me.blog.korn123.easydiary.viewholders

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import io.github.aafactory.commons.utils.CommonUtils
import me.blog.korn123.easydiary.R

class PhotoViewHolder(
        itemView: View, 
        val activity: Activity,
        private val itemCount: Int 
) : RecyclerView.ViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.photo)
    
    internal fun bindTo(photoPath: String, position: Int) {
        val point =  CommonUtils.getDefaultDisplay(activity)
        val size = point.x 
        var roundCornerDpUnit = 5F 
                
        when (itemCount) {
            1 -> {
                imageView.layoutParams.width = size
                imageView.layoutParams.height = size
                
            }
            3, 5, 6 -> {
                if (position < 1) {
                    imageView.layoutParams.width = (size * 0.8).toInt() 
                    imageView.layoutParams.height = size
                } else {
                    imageView.layoutParams.width = (size * 0.2).toInt()
                    imageView.layoutParams.height = (size * 0.2).toInt()
                }
            }
            2, 4 -> {
                imageView.layoutParams.width = size / 2
                imageView.layoutParams.height = size / 2
            }
            else -> {
                if (position < 1) {
                    imageView.layoutParams.width = size
                    imageView.layoutParams.height = (size * 0.8).toInt()
                } else {
                    imageView.layoutParams.width = (size * 0.2).toInt()
                    imageView.layoutParams.height = (size * 0.2).toInt()
                }
            }
        }

        Glide.with(imageView.context)
                .load(photoPath)
//                .apply(RequestOptions().placeholder(R.drawable.ic_aaf_photos).fitCenter())
                .apply(RequestOptions().transforms(CenterCrop()))
//                .apply(RequestOptions().transforms(CenterCrop(), RoundedCorners(CommonUtils.dpToPixel(imageView.context, roundCornerDpUnit))))
                .into(imageView)
    }
}
