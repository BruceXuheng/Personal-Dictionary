package com.android.study.test_card.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.util.Linkify
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

/**
 * @description:
 *
 * @Date: 2020/7/27
 */
class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    var views: SparseArray<View> = SparseArray()
    var mLayoutId: Int? = null

    companion object {
        //静态方法
        @JvmStatic
        fun get(context: Context?, convertView: View?, parent: ViewGroup?, layoutId: Int?): ViewHolder {
            if (convertView == null) {
                val holder2 = LayoutInflater.from(context).inflate(layoutId!!, parent, false)
                val holder1: ViewHolder = ViewHolder(holder2)
                holder1.mLayoutId = layoutId
                return holder1
            } else {
                return convertView.tag as ViewHolder
            }
        }
    }

    fun getLayoutId(): Int {
        return mLayoutId!!
    }

    fun <T : View?> getView(viewId: Int): T? {
        var view: View? = this.views.get(viewId)
        if (view == null) {
            view = itemView.findViewById(viewId)
            this.views.put(viewId, view)
        }
        return view as T?
    }

    fun setText(viewId: Int, text: CharSequence?):ViewHolder? {
        val tv = getView<View>(viewId) as TextView
        tv.text = text
        return this
    }

    fun setSelected(viewId: Int, selected: Boolean):ViewHolder? {
        val v = getView<View>(viewId)!!
        v.isSelected = selected
        return this
    }

    fun setImageResource(viewId: Int, resId: Int):ViewHolder? {
        val view = getView<View>(viewId) as ImageView
        view.setImageResource(resId)
        return this
    }

    fun setImageBitmap(viewId: Int, bitmap: Bitmap?):ViewHolder? {
        val view = getView<View>(viewId) as ImageView
        view.setImageBitmap(bitmap)
        return this
    }

    fun setImageDrawable(viewId: Int, drawable: Drawable?):ViewHolder? {
        val view = getView<View>(viewId) as ImageView
        view.setImageDrawable(drawable)
        return this
    }

    fun setBackgroundColor(viewId: Int, color: Int):ViewHolder? {
        val view = getView<View>(viewId)!!
        view.setBackgroundColor(color)
        return this
    }

    fun setBackgroundRes(viewId: Int, backgroundRes: Int):ViewHolder? {
        val view = getView<View>(viewId)!!
        view.setBackgroundResource(backgroundRes)
        return this
    }

    fun setTextColor(viewId: Int, textColor: Int):ViewHolder? {
        val view = getView<View>(viewId) as TextView
        view.setTextColor(textColor)
        return this
    }

    fun setTextColorRes(viewId: Int, textColorRes: Int):ViewHolder? {
        val view = getView<View>(viewId) as TextView
        view.setTextColor(itemView.context.resources.getColor(textColorRes))
        return this
    }

    @SuppressLint("NewApi")
    fun setAlpha(viewId: Int, value: Float):ViewHolder? {
        if (Build.VERSION.SDK_INT >= 11) {
            getView<View>(viewId)!!.alpha = value
        } else {
            val alpha = AlphaAnimation(value, value)
            alpha.duration = 0L
            alpha.fillAfter = true
            getView<View>(viewId)!!.startAnimation(alpha)
        }
        return this
    }

    fun setVisible(viewId: Int, visible: Boolean):ViewHolder? {
        val view = getView<View>(viewId)!!
        view.visibility = if (visible) View.VISIBLE else View.GONE
        return this
    }

    fun linkify(viewId: Int):ViewHolder? {
        val view = getView<View>(viewId) as TextView
        Linkify.addLinks(view, Linkify.ALL)
        return this
    }

    fun setTypeface(typeface: Typeface?, vararg viewIds: Int):ViewHolder? {
        val var4 = viewIds.size
        for (var5 in 0 until var4) {
            val viewId = viewIds[var5]
            val view = getView<View>(viewId) as TextView
            view.setTypeface(typeface)
            view.paintFlags = view.paintFlags or 128
        }
        return this
    }

    fun setProgress(viewId: Int, progress: Int):ViewHolder? {
        val view = getView<View>(viewId) as ProgressBar
        view.progress = progress
        return this
    }

    fun setProgress(viewId: Int, progress: Int, max: Int):ViewHolder? {
        val view = getView<View>(viewId) as ProgressBar
        view.max = max
        view.progress = progress
        return this
    }

    fun setMax(viewId: Int, max: Int):ViewHolder? {
        val view = getView<View>(viewId) as ProgressBar
        view.max = max
        return this
    }

    fun setRating(viewId: Int, rating: Float):ViewHolder? {
        val view = getView<View>(viewId) as RatingBar
        view.rating = rating
        return this
    }

    fun setRating(viewId: Int, rating: Float, max: Int):ViewHolder? {
        val view = getView<View>(viewId) as RatingBar
        view.max = max
        view.rating = rating
        return this
    }

    fun setTag(viewId: Int, tag: Any?):ViewHolder? {
        val view = getView<View>(viewId)!!
        view.tag = tag
        return this
    }

    fun setTag(viewId: Int, key: Int, tag: Any?):ViewHolder? {
        val view = getView<View>(viewId)!!
        view.setTag(key, tag)
        return this
    }

    fun setChecked(viewId: Int, checked: Boolean):ViewHolder? {
        val view = getView<View>(viewId) as Checkable
        view.isChecked = checked
        return this
    }

    fun setOnClickListener(viewId: Int, listener: View.OnClickListener?):ViewHolder? {
        val view = getView<View>(viewId)!!
        view.setOnClickListener(listener)
        return this
    }

    fun setOnTouchListener(viewId: Int, listener: View.OnTouchListener?):ViewHolder? {
        val view = getView<View>(viewId)!!
        view.setOnTouchListener(listener)
        return this
    }

    fun setOnLongClickListener(viewId: Int, listener: View.OnLongClickListener?):ViewHolder? {
        val view = getView<View>(viewId)!!
        view.setOnLongClickListener(listener)
        return this
    }

    fun setItemVisible(visible: Boolean) {
        if (null != itemView) {
            if (visible) {
                if (null != itemView.layoutParams) {
                    itemView.layoutParams.width = -1
                    itemView.layoutParams.height = -2
                } else {
                    itemView.layoutParams = AbsListView.LayoutParams(-1, -2)
                }
                itemView.visibility = View.VISIBLE
            } else {
                if (null != itemView.layoutParams) {
                    itemView.layoutParams.width = -1
                    itemView.layoutParams.height = 1
                } else {
                    itemView.layoutParams = AbsListView.LayoutParams(-1, 1)
                }
                itemView.visibility = View.GONE
            }
        }
    }

    fun setHItemVisible(visible: Boolean) {
        if (null != itemView) {
            if (visible) {
                if (null != itemView.layoutParams) {
                    itemView.layoutParams.width = -2
                    itemView.layoutParams.height = -2
                } else {
                    itemView.layoutParams = AbsListView.LayoutParams(-1, -2)
                }
                itemView.visibility = View.VISIBLE
            } else {
                if (null != itemView.layoutParams) {
                    itemView.layoutParams.width = -1
                    itemView.layoutParams.height = 1
                } else {
                    itemView.layoutParams = AbsListView.LayoutParams(-1, 1)
                }
                itemView.visibility = View.GONE
            }
        }
    }
}

//fun deded(context: Context?, convertView: View?, parent: ViewGroup?, layoutId: Int?){
//    ViewHolder.get(context,convertView, parent, layoutId)
//}