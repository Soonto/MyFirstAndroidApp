package com.example.layoutBase.bubble.onBubbleClickListener

import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import com.example.layoutBase.adapter.MyAdapter
import com.example.layoutBase.bubble.Bubble
import com.example.layoutBase.bubble.dataSource.DataSource
import com.example.layoutBase.bubble.dataSource.NumOfListView

import com.example.layoutBase.databinding.ActivityMainBinding

typealias Update = () -> Unit

class OnBubbleClickListener(
    private val binding: ActivityMainBinding,
    private val numOfListView: NumOfListView,
    var adapterR: MyAdapter,
    val update: Update
) : AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var selectView = 0
        selectView = when (numOfListView) {
            NumOfListView.RVIEW -> 2
            NumOfListView.CVIEW -> 1
            NumOfListView.LVIEW -> 0
        }
        Log.d("1234567", view.toString())
        val adapter = parent?.adapter
        with(adapter?.getItem(position) as Bubble) {
            if (isLast) {
                DataSource.bubbles[selectView].remove(this)
                //binding.centerPos.addView(adapterR.getView(0, null, binding.leftListView))
                if (DataSource.bubbles[selectView].size > 0) {
                    DataSource.bubbles[selectView][0].isLast = true
                }
                update()
            }
        }
    }


}
