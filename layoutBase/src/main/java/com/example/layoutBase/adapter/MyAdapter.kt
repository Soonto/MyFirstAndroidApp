package com.example.layoutBase.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.marginBottom
import androidx.core.view.marginStart
import com.example.layoutBase.bubble.Bubble
import com.example.layoutBase.databinding.ItemViewBinding

class MyAdapter(
    private val listBubble : List<Bubble>
) : BaseAdapter() {

    override fun getCount(): Int {
        return listBubble.size
    }

    override fun getItem(position: Int): Bubble {
        return listBubble[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = convertView?.tag as ItemViewBinding? ?: createBinding(parent.context)
        //Log.d("1234567", "ok")
        val bubble = getItem(position)
        binding.nameOfBubble.text = bubble.weight.toString()
        val set = ConstraintSet()
        set.clone(binding.root)
        set.constrainPercentWidth(binding.nameOfBubble.id, bubble.weight.toFloat()/5)
        set.applyTo(binding.root)

        return binding.root
    }

    private fun createBinding(context: Context): ItemViewBinding {
        Log.d("1234567", "okK")
        val binding = ItemViewBinding.inflate(LayoutInflater.from(context))
        binding.root.tag = binding
        return binding

    }
}