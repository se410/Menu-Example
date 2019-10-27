package com.example.menuexample

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AbsListView
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_context_menu.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.R.attr.name



class ContextualActionModeActivity : AppCompatActivity() {

    private val actionModeCallback = object : ActionMode.Callback {

        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode!!.menuInflater.inflate(R.menu.context_menu, menu)
            Log.i("zakarea", "zakarea")
            return true
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            return when (item!!.itemId) {
                R.id.set_color -> {
//                    setColor(info)
                    true
                }

                R.id.default_color -> {
//                    setDefaultColor(info)
                    true
                }

                else -> false
            }
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {

            return false
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
//            actionm = null
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)
        title = title.toString() + ": Contextual Action Mode"

        with(lv_context_menu){

            val positionsList = ArrayList<Int>()
            choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
            setMultiChoiceModeListener(object : AbsListView.MultiChoiceModeListener {
                override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
//                    val info = item!!.menuInfo as AdapterView.AdapterContextMenuInfo
                    return when (item!!.itemId) {
                        R.id.set_color -> {
                            Util().setColor(lv_context_menu, positionsList)
                            mode!!.finish()
                            true
                        }

                        R.id.default_color -> {
                            Util().setDefaultColor(lv_context_menu, positionsList)
                            mode!!.finish()
                            true
                        }

                        else -> false
                    }

                }

                override fun onItemCheckedStateChanged(
                    mode: ActionMode?,
                    position: Int,
                    id: Long,
                    checked: Boolean
                ) {
                    if(checked) {
                        positionsList.add(position)
                        lv_context_menu.get(position).setBackgroundColor(Color.LTGRAY)
                    }
                    else {
                        positionsList.remove(position)
                        lv_context_menu.get(position).setBackgroundColor(Color.TRANSPARENT)
                    }

                }

                override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    mode!!.menuInflater.inflate(R.menu.context_menu, menu)
                    return true

                }

                override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    return false
                }

                override fun onDestroyActionMode(mode: ActionMode?) {

                }

            })
        }
    }
}