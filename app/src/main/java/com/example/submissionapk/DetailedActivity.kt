package com.example.submissionapk

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.EventLogTags.Description
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        // calling the action bar
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }


        val shoe = intent.getParcelableExtra<Shoe>("shoe")

        if (shoe !=null){
            val textView: TextView = findViewById(R.id.textClassic)
            val imageView : ImageView = findViewById(R.id.imageClassic)
            val descriptionData: TextView = findViewById(R.id.dataDescription)

            textView.text = shoe.name
            imageView.setImageResource(shoe.photo)
            descriptionData.text = shoe.description

        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}