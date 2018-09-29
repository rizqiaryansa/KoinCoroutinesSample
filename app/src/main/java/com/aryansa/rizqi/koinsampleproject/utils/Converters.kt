package com.aryansa.rizqi.koinsampleproject.utils

import android.animation.Animator
import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatImageView
import android.view.View
import com.aryansa.rizqi.koinsampleproject.R
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

class Converters {

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: AppCompatImageView, imageUrl: String) {
            Glide.with(imageView.context.applicationContext)
                    .load(imageUrl)
                    .transition(GenericTransitionOptions.with(android.R.anim.fade_in))
                    .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("loadImageCircle")
        fun loadImageCircle(imageView: CircleImageView, imageUrl: String?) {
            Glide.with(imageView.context.applicationContext)
                    .load(imageUrl)
                    .apply(RequestOptions()
                            .placeholder(R.drawable.image_placeholder)
                            .error(R.drawable.image_placeholder)
                            .dontAnimate())
                    .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("showView")
        fun showView(view: View, hide: Boolean){
            if(hide) {
                view.alpha = 0f
                view.animate().alpha(1f).duration = GLOBAL_ANIM_DURATION
            }
        }

        @JvmStatic
        @BindingAdapter("hideView")
        fun hideView(view: View, hide: Boolean){
            if (hide) {
                view.visibility = View.VISIBLE
                view.alpha = 1f
            } else {
                view.animate().alpha(0f).setDuration(GLOBAL_ANIM_DURATION).setListener(object : Animator.AnimatorListener {

                    override fun onAnimationRepeat(p0: Animator?) {

                    }

                    override fun onAnimationEnd(p0: Animator?) {
                        view.visibility = View.INVISIBLE
                    }

                    override fun onAnimationStart(p0: Animator?) {

                    }

                    override fun onAnimationCancel(p0: Animator?) {

                    }

                })
            }
        }

    }
}