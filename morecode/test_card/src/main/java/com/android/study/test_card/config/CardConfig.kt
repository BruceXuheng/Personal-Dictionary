package com.android.study.test_card.config

import android.content.Context
import android.util.TypedValue

/**
 * @description:
 *
 * @Date: 2020/7/28
 */
class CardConfig {

    companion object {
        @JvmField
        var MAX_SHOW_COUNT: Int? = null

        @JvmField
        var SCALE_GAP: Float? = null

        @JvmField
        var TRANS_Y_GAP: Int? = null

        @JvmStatic
        fun initConfig(context: Context) {
            MAX_SHOW_COUNT = 8
            SCALE_GAP = 0.05f
            // 把非标准尺寸转换成标准尺寸
            TRANS_Y_GAP = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15f, context.resources.displayMetrics).toInt()
        }
    }


}