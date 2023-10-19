package com.onepiece.eveapp.dialog

import android.content.Context
import android.widget.TextView
import com.lxj.xpopup.core.CenterPopupView
import com.onepiece.eveapp.R

typealias SureCallback = () -> Unit

class AddStationDialog( context: Context,val sureCallback: SureCallback) : CenterPopupView(context) {



    override fun getImplLayoutId(): Int {
        return R.layout.dialog_add_station
    }

    override fun onCreate() {

        super.onCreate()
        findViewById<TextView>(R.id.sure_btn).setOnClickListener {
            sureCallback.invoke()
            dismiss()
        }
    }
}