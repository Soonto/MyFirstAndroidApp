package com.example.layoutBase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.example.layoutBase.adapter.MyAdapter
import com.example.layoutBase.bubble.Bubble
import com.example.layoutBase.bubble.dataSource.DataSource
import com.example.layoutBase.bubble.dataSource.NumOfListView
import com.example.layoutBase.bubble.onBubbleClickListener.OnBubbleClickListener
import com.example.layoutBase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapterC: MyAdapter
    lateinit var adapterL: MyAdapter
    lateinit var adapterR: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
        setAdapters()
        //binding.rightPos.addView(adapterR.getView(1, null, binding.rightListView))
        //binding.centerPos.addView(adapterR.getView(0, null, binding.rightListView))
        //binding.leftPos.addView(adapterR.getView(2, null, binding.rightListView))
    }
    private fun setAdapters() {
        adapterL = MyAdapter(DataSource.bubbles[0])
        adapterC = MyAdapter(DataSource.bubbles[1])
        adapterR = MyAdapter(DataSource.bubbles[2])
        with(binding) {
            leftListView.adapter = adapterL
            centerListView.adapter = adapterC
            rightListView.adapter = adapterR
        }
    }
    private fun setListeners() {
        with(binding) {
            leftListView.onItemClickListener = OnBubbleClickListener(binding, NumOfListView.LVIEW, adapterL) { adapterL.notifyDataSetChanged() }
            //centerListView.onItemClickListener =OnBubbleClickListener(binding, NumOfListView.CVIEW) { adapterC.notifyDataSetChanged() }
           // rightListView.onItemClickListener = OnBubbleClickListener(binding,NumOfListView.RVIEW) { adapterR.notifyDataSetChanged() }
        }
    }
}



