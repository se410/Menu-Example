package com.example.menuexample

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_popup_menu.*
import kotlin.math.nextDown
import kotlin.math.nextUp

class PopupMenuActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_menu)
        title = title.toString() + " :Popup Menu"
    }

    fun showPopup(view: View) {
        PopupMenu(this, view).apply {
            // MainActivity implements OnMenuItemClickListener
            setOnMenuItemClickListener(this@PopupMenuActivity)
            inflate(R.menu.context_menu)
            show()
        }
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.set_color -> {
                popupLayout.setBackgroundColor(Color.argb((0 until 255).random(), (0 until 255).random(), (0 until 255).random(), (0 until 255).random()))
                true
            }
            R.id.default_color -> {
                popupLayout.setBackgroundColor(Color.TRANSPARENT)
                true
            }
            else -> false
        }
    }
}