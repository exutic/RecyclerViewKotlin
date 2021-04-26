package com.example.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.adapters.ExampleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList = generateDummyList(100)

        val recyclerView :RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = ExampleAdapter(exampleList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_launcher_background
                1 -> R.drawable.ic_launcher_background
                else -> R.drawable.ic_launcher_background
            }
            val item = ExampleItem(drawable,"Title $i","Description $i","Date $i")
            list +=item
        }
        return list
    }
}