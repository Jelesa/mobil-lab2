package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CoursesAdapter.Listener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categories: RecyclerView = findViewById(R.id.recyclerView)
        categories.layoutManager = LinearLayoutManager(this)

        var datalist: List<DataItem> = listOf(DataItem(getString(R.string.categories_drinks), R.drawable.list_categories_drinks),
                                              DataItem(getString(R.string.categories_dishes), R.drawable.list_categories_dishes),
                                              DataItem(getString(R.string.categories_snacks), R.drawable.list_categories_snacks),
                                              DataItem(getString(R.string.categories_salads), R.drawable.list_categories_salads),
                                              DataItem(getString(R.string.categories_desserts), R.drawable.list_categories_desserts))

        val adapter: CoursesAdapter = CoursesAdapter(datalist, this)
        categories.adapter = adapter
    }

    override fun onCLick(dataItem: DataItem) {
        val intent = Intent(this, RecipesActivity::class.java)
        intent.putExtra("name", dataItem.text)
        startActivity(intent)
    }
}
