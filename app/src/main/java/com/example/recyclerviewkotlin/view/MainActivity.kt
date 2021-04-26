package com.example.recyclerviewkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.R
import com.example.recyclerviewkotlin.adapters.ExampleAdapter
import com.example.recyclerviewkotlin.model.ExampleItem
import kotlin.random.Random

class MainActivity :
    AppCompatActivity(),
    ExampleAdapter.OnItemClickListener {
    private val exampleList = generateDummyList(25)
    private val adapter = ExampleAdapter(exampleList, this)
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_launcher_background
                1 -> R.drawable.ic_launcher_background
                else -> R.drawable.ic_launcher_background
            }
            val item = ExampleItem(drawable, "Title $i", "Description $i", "Date $i")
            list += item
        }
        return list
    }

    fun insertItem(view: View) {
        val index = Random.nextInt(6)

        val newItem = ExampleItem(
            R.drawable.ic_launcher_foreground,
            "Lebron James at $index Position",
            "NBA Player",
            "2021"
        )

        exampleList.add(index, newItem)

        adapter.notifyItemInserted(index)
    }

    fun removeItem(view: View) {
        val index: Int = Random.nextInt(6)

        exampleList.removeAt(index)

        adapter.notifyItemRemoved(index)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position Clicked", Toast.LENGTH_SHORT).show()
        val clickedItem : ExampleItem = exampleList[position]
        clickedItem.title = "Aryan Goodarzi"
        clickedItem.description = "Best Gamer In the world"
        clickedItem.date = "Just Now"

        adapter.notifyItemChanged(position)

        //in here we can go to in another page too
    }
}