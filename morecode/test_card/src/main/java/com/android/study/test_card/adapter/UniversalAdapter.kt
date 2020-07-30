package com.android.study.test_card.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 * @description:
 *
 * @Date: 2020/7/27
 */
//abstract class UniversalAdapter<T>(): RecyclerView.Adapter<ViewHolder>() {
//
//    private var mContext:Context? = null
//    private var mLayoutId:Int? = null
//    private var mDatas:MutableList<T>? = null
//    private var mInflater:LayoutInflater? = null
//    private var mRv:ViewGroup? = null
//    private var mOnItemClickListener: OnItemClickListener<T>? = null
//
//    constructor(context: Context?, datas: MutableList<T>?, layoutId: Int) : this() {
//        mContext = context
//        mInflater = LayoutInflater.from(context)
//        mLayoutId = layoutId
//        mDatas = datas
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder.get(mContext, null as View?, parent, mLayoutId)
//    }
//
//    override fun getItemCount(): Long {
//        return (mDatas?.size ?: 0) as Long
//    }
//
//
//    open fun isEnabled(viewType: Int): Boolean {
//        return true
//    }
//
//
//    protected open fun setListener(position: Int, viewHolder: ViewHolder) {
//        if (isEnabled(getItemViewType(position))) {
//            viewHolder.itemView.setOnClickListener { v ->
//                if (mOnItemClickListener != null) {
//                    mOnItemClickListener!!.onItemClick(mRv, v, mDatas!![position], position)
//                }
//            }
//            viewHolder.itemView.setOnLongClickListener { v ->
//                if (mOnItemClickListener != null) {
//                    val position = getPosition(viewHolder)
//                    mOnItemClickListener!!.onItemLongClick(mRv, v, mDatas!![position], position)
//                } else {
//                    false
//                }
//            }
//        }
//    }
//
//    fun getPosition(viewHolder: RecyclerView.ViewHolder):Int{
//        return viewHolder.adapterPosition
//    }
//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        this.setListener(position,holder)
//    }
//
//    protected open fun setListener(position: Int, viewHolder: ViewHolder) {
//        if (isEnabled(getItemViewType(position))) {
//            viewHolder.itemView.setOnClickListener { v ->
//                if (mOnItemClickListener != null) {
//                    mOnItemClickListener.onItemClick(mRv, v, mDatas!![position], position)
//                }
//            }
//            viewHolder.itemView.setOnLongClickListener { v ->
//                if (mOnItemClickListener != null) {
//                    val position = getPosition(viewHolder)
//                    mOnItemClickListener.onItemLongClick(mRv, v, mDatas!![position], position)
//                } else {
//                    false
//                }
//            }
//        }
//    }
//
//    // 将 var2的数据 显示在ViewHolder 的对应 View 中
//    abstract fun convert(var1: ViewHolder?, var2: T)
//
//    override fun getItemCount(): Int {
//        return if (mDatas != null) mDatas.size else 0
//    }
//
//    open fun setDatas(list: List<T>?) {
//        if (mDatas != null) {
//            if (null != list) {
//                val temp: ArrayList<*> = ArrayList<Any?>()
//                temp.addAll(list)
//                mDatas.clear()
//                mDatas.addAll(temp)
//            } else {
//                mDatas.clear()
//            }
//        } else {
//            mDatas = list
//        }
//        notifyDataSetChanged()
//    }
//
//
//}


abstract class UniversalAdapter<T>(context: Context, datas: MutableList<T>?, layoutId: Int) : RecyclerView.Adapter<ViewHolder?>() {
    protected var mContext: Context
    protected var mLayoutId: Int
    protected var mDatas: MutableList<T>?
    protected var mInflater: LayoutInflater
    protected var mRv: ViewGroup? = null
    private var mOnItemClickListener: OnItemClickListener<T>? = null
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<T>?): UniversalAdapter<T> {
        mOnItemClickListener = onItemClickListener
        return this
    }

    fun getmOnItemClickListener(): OnItemClickListener<T>? {
        return mOnItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder.get(mContext, null as View?, parent, mLayoutId)
        if (null == mRv) {
            mRv = parent
        }
        return viewHolder
    }

    protected fun getPosition(viewHolder: RecyclerView.ViewHolder): Int {
        return viewHolder.adapterPosition
    }

    protected fun isEnabled(viewType: Int): Boolean {
        return true
    }

    @Deprecated("")
    protected fun setListener(parent: ViewGroup?, viewHolder: ViewHolder, viewType: Int) {
        if (isEnabled(viewType)) {
            viewHolder.itemView.setOnClickListener { v ->
                if (mOnItemClickListener != null) {
                    val position = getPosition(viewHolder)
                    mOnItemClickListener?.onItemClick(parent, v, mDatas!![position], position)
                }
            }
            viewHolder.itemView.setOnLongClickListener { v ->
                if (mOnItemClickListener != null) {
                    val position = getPosition(viewHolder)
                    mOnItemClickListener!!.onItemLongClick(parent, v, mDatas!![position], position)
                } else {
                    false
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.setListener(position, holder)
        convert(holder, mDatas!![position])
    }

    protected fun setListener(position: Int, viewHolder: ViewHolder) {
        if (isEnabled(getItemViewType(position))) {
            viewHolder.itemView.setOnClickListener { v ->
                if (mOnItemClickListener != null) {
                    mOnItemClickListener?.onItemClick(mRv, v, mDatas!![position], position)
                }
            }
            viewHolder.itemView.setOnLongClickListener { v ->
                if (mOnItemClickListener != null) {
                    val position = getPosition(viewHolder)
                    mOnItemClickListener!!.onItemLongClick(mRv, v, mDatas!![position], position)
                } else {
                    false
                }
            }
        }
    }

    // 将 var2的数据 显示在ViewHolder 的对应 View 中
    abstract fun convert(var1: ViewHolder?, var2: T)
    override fun getItemCount(): Int {
        return if (mDatas != null) mDatas!!.size else 0
    }

    fun setDatas(list: MutableList<T>?) {
        if (mDatas != null) {
            if (null != list) {
                mDatas!!.clear()
                mDatas!!.addAll(list)
            } else {
                mDatas!!.clear()
            }
        } else {
            mDatas = list
        }
        notifyDataSetChanged()
    }

    fun remove(i: Int) {
        if (null != mDatas && mDatas!!.size > i && i > -1) {
            mDatas!!.removeAt(i)
            notifyDataSetChanged()
        }
    }

    fun addDatas(list: MutableList<T>?) {
        if (null != list) {
            if (mDatas != null) {
                mDatas!!.addAll(list)
            } else {
                mDatas = list
            }
            notifyDataSetChanged()
        }
    }

    fun getDatas(): List<T>? {
        return mDatas
    }

    fun getItem(position: Int): T? {
        return if (position > -1 && null != mDatas && mDatas!!.size > position) mDatas!![position] else null
    }

    init {
        mContext = context
        mInflater = LayoutInflater.from(context)
        mLayoutId = layoutId
        mDatas = datas
    }
}

