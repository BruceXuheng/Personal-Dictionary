package com.android.study.test_card.bean

import java.util.*


/**
 * @description:
 *
 * @Date: 2020/7/27
 */
open class SlideCardBean() {

    open var position: Int? = null
        get() = field
        set(value) {
            field = value
        }
    open var url: String? = null
        get() = field
        set(value) {
            field = value
        }
    open var name: String? = null
        get() = field
        set(value) {
            field = value
        }


    constructor( position:Int, url:String, name:String):this(){
        this.position = position
        this.url = url
        this.name = name
    }

    override fun toString(): String {
        return "SlideCardBean(position=$position, url=$url, name=$name)"
    }

//    fun setPosition(position:Int){
//        this.position=position
//    }
//
//    fun getPosition(): Int? {
//        return this.position
//    }

    companion object{

        @JvmStatic
        fun initDatas(): MutableList<SlideCardBean> {
            val datas: MutableList<SlideCardBean> = ArrayList()
            var i = 1
            datas.add(SlideCardBean(i++, "https://www.baidu.com/img/flexible/logo/pc/result.png", "百度1"))
            datas.add(SlideCardBean(i++, "https://www.baidu.com/img/flexible/logo/pc/result.png", "百度2"))
            datas.add(SlideCardBean(i++, "https://www.baidu.com/img/flexible/logo/pc/result.png", "百度3"))
            datas.add(SlideCardBean(i++, "https://www.baidu.com/img/flexible/logo/pc/result.png", "百度4"))
            datas.add(SlideCardBean(i++, "https://www.baidu.com/img/flexible/logo/pc/result.png", "百度5"))
            datas.add(SlideCardBean(i++, "https://www.baidu.com/img/flexible/logo/pc/result.png", "百度6"))
            datas.add(SlideCardBean(i++, "https://www.baidu.com/img/flexible/logo/pc/result.png", "百度7"))
            datas.add(SlideCardBean(i++, "https://www.baidu.com/img/flexible/logo/pc/result.png", "百度8"))
            return datas
        }
    }

}