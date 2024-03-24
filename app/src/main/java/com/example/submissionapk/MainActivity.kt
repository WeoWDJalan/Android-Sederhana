package com.example.submissionapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvShoe: RecyclerView
    private var listShoe = ArrayList<Shoe>()
    lateinit var imageView: ImageView
    private lateinit var shoeAdapter: ListShoeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvShoe = findViewById(R.id.rv_shoe)
        rvShoe.setHasFixedSize(true)

        listShoe = ArrayList()

        listShoe.addAll(getListShoe())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun getListShoe(): ArrayList<Shoe> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listShoe = ArrayList<Shoe>()
        for (i in dataName.indices) {
            val shoe = Shoe(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listShoe.add(shoe)
        }
        return listShoe
    }

    private fun showRecyclerList() {
        rvShoe.layoutManager = LinearLayoutManager(this)
        val listShoeAdapter = ListShoeAdapter(listShoe)
        rvShoe.adapter = listShoeAdapter

        listShoeAdapter.onItemClick ={
            val intent = Intent(this ,DetailedActivity::class.java)
            intent.putExtra("shoe", it)
            startActivity(intent)
        }


    }
}