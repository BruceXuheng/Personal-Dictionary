package com.android.study.test_card.adapter

import android.view.View
import android.view.ViewGroup

/**
 * @description:
 *
 * @Date: 2020/7/27
 */
interface OnItemClickListener<T> {

    fun onItemClick(var1: ViewGroup?, var2: View?, var3: T, var4: Int)

    fun onItemLongClick(var1: ViewGroup?, var2: View?, var3: T, var4: Int): Boolean

}