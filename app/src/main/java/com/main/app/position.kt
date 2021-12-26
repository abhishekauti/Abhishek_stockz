package com.main.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class position : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_position)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.position_nav_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_timer -> {Toast.makeText(this,"Timer Selected",Toast.LENGTH_SHORT).show()
                return true}

            R.id.nav_diamond -> {
                Toast.makeText(this,"Diamonds Selected",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.nav_third_item -> {
                Toast.makeText(this,"Third item Selected",Toast.LENGTH_SHORT).show()
                return true
            }
            else ->{
                return super.onOptionsItemSelected(item)
            }
        }

    }
}