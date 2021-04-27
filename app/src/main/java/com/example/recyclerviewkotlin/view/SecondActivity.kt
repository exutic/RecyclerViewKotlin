package com.example.recyclerviewkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerviewkotlin.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //TEst Class and activity

        var img_back: ImageView = findViewById(R.id.img_back)
        var img_send: ImageView = findViewById(R.id.img_send)
        var img_save: ImageView = findViewById(R.id.img_favorite)
        var imageView: ImageView = findViewById(R.id.imageView)

        var tv_content_title: TextView = findViewById(R.id.tv_content_title)
        var tv_author: TextView = findViewById(R.id.tv_author)
        var tv_published_date: TextView = findViewById(R.id.tv_published_date)
        var tv_content: TextView = findViewById(R.id.tv_content)

        var btn_news_source: Button = findViewById(R.id.btn_news_source)


        val title:String = intent.getStringExtra("NewItemTitle").toString()
        val description:String = intent.getStringExtra("NewItemDescription").toString()
        val data:String = intent.getStringExtra("NewItemData").toString()

        tv_content_title.text = title
        tv_author.text= "Aryan"
        tv_published_date.text = data
        tv_content.text = description

        img_back.setOnClickListener(View.OnClickListener {super.onBackPressed()})
    }
}