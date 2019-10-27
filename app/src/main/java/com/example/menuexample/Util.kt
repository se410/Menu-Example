package com.example.menuexample

import android.graphics.Color
import android.widget.AdapterView
import android.widget.ListView
import androidx.core.view.get

class Util {

    fun setColor(listView: ListView, selectedItemIndexes: ArrayList<Int>) {

        for (pos: Int in selectedItemIndexes) {
            when (pos) {

                0 -> {
                    listView.get(pos).setBackgroundColor(Color.RED)
                }
                1 -> {
                    listView.get(pos).setBackgroundColor(Color.GREEN)
                }
                2 -> {
                    listView.get(pos).setBackgroundColor(Color.BLUE)
                }
                3 -> {
                    listView.get(pos).setBackgroundColor(Color.MAGENTA)
                }
                4 -> {
                    listView.get(pos).setBackgroundColor(Color.YELLOW)
                }
                5 -> {
                    listView.get(pos).setBackgroundColor(Color.BLACK)
                }
                6 -> {
                    listView.get(pos).setBackgroundColor(Color.WHITE)
                }
                7 -> {
                    listView.get(pos).setBackgroundColor(Color.GRAY)
                }
            }

        }
    }

    fun setDefaultColor(listView: ListView, selectedItemIndexes: ArrayList<Int>) {
        for (pos: Int in selectedItemIndexes) {
            listView.get(pos).setBackgroundColor(Color.TRANSPARENT)
        }
    }

}