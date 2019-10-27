package com.example.menuexample

import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_context_menu.*

internal class ContextMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)
        registerForContextMenu(lv_context_menu)
        title = title.toString() + " :Context Menu"
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo

        return when (item.itemId) {
            R.id.set_color -> {
                setColor(info)
                true
            }

            R.id.default_color -> {
                setDefaultColor(info)
                true
            }

            else -> return super.onContextItemSelected(item)
        }

    }

    fun setColor(item: AdapterView.AdapterContextMenuInfo) {

        when (item.position) {

            0 -> {
                item.targetView.setBackgroundColor(Color.RED)
            }
            1 -> {
                item.targetView.setBackgroundColor(Color.GREEN)
            }
            2 -> {
                item.targetView.setBackgroundColor(Color.BLUE)
            }
            3 -> {
                item.targetView.setBackgroundColor(Color.MAGENTA)
            }
            4 -> {
                item.targetView.setBackgroundColor(Color.YELLOW)
            }
            5 -> {
                item.targetView.setBackgroundColor(Color.BLACK)
            }
            6 -> {
                item.targetView.setBackgroundColor(Color.WHITE)
            }
            7 -> {
                item.targetView.setBackgroundColor(Color.GRAY)
            }

        }
    }

    fun setDefaultColor(item: AdapterView.AdapterContextMenuInfo) {
        item.targetView.setBackgroundColor(Color.TRANSPARENT)
    }


}
