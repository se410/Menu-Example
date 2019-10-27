package com.example.menuexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = title.toString() + ": Option Menu"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){

            R.id.send -> {
                tv_info.text = item.title.toString() + getString(R.string.item_info_message)
                true
            }

            R.id.account -> {
                tv_info.text = item.title.toString() + getString(R.string.item_info_message)
                true
            }

            R.id.context_menu -> {
                val intentContextMenu: Intent = Intent(this,  ContextMenuActivity::class.java)
                startActivity(intentContextMenu)
                true
            }

            R.id.contextual_action_mode -> {
                val intentContextActionModeMenu: Intent = Intent(this,  ContextualActionModeActivity::class.java)
                startActivity(intentContextActionModeMenu)
                true
            }

            R.id.popup_menu -> {
                val intentPopupMenu: Intent = Intent(this,  PopupMenuActivity::class.java)
                startActivity(intentPopupMenu)
                true
            }



            else -> return super.onOptionsItemSelected(item)
        }

    }
}
