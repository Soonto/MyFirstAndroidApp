package com.example.layoutBase.bubble.dataSource

import com.example.layoutBase.bubble.Bubble

object DataSource {

    private val dataL = mutableListOf<Bubble>()
    private val dataC = mutableListOf<Bubble>(
        Bubble(1, 1, true),
        Bubble(2, 2),
        Bubble(3, 3, ))
    private val dataR = mutableListOf(
        Bubble(1, 1, true),
        Bubble(2, 2),
        Bubble(3, 3, ))
    val bubbles = listOf(dataL, dataC, dataR)


}