package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecipesActivity : AppCompatActivity(), CoursesAdapter.Listener {

    var recipes: Map<String, List<DataItem>>
        get() = mapOf(getString(R.string.categories_drinks) to listOf(DataItem(getString(R.string.drinks_coconut), R.drawable.list_categories_drinks),
                                          DataItem(getString(R.string.drinks_cranberry), R.drawable.list_recipes_drinks_cranberry),
                                          DataItem(getString(R.string.drinks_coffee), R.drawable.list_recipes_drinks_coffee),
                                          DataItem(getString(R.string.drinks_limonad), R.drawable.list_recipes_drinks_limonad)),
                      getString(R.string.categories_dishes) to listOf(DataItem(getString(R.string.dishes_baked_chiken), R.drawable.list_categories_dishes),
                                          DataItem(getString(R.string.dishes_potato), R.drawable.dishes_potato),
                                          DataItem(getString(R.string.dishes_chiken_balls), R.drawable.dishes_chiken_balls),
                                          DataItem(getString(R.string.dishes_ric_egg), R.drawable.dishes_ric_egg)),
                      getString(R.string.categories_salads) to listOf(DataItem(getString(R.string.salads_srimp), R.drawable.list_categories_salads),
                                          DataItem(getString(R.string.salads_ceaser), R.drawable.salads_caezer),
                                          DataItem(getString(R.string.salads_mimoza), R.drawable.salads_mimoza),
                                          DataItem(getString(R.string.salads_gazaphuli), R.drawable.salads_gazaphuli)),
                      getString(R.string.categories_snacks) to listOf(DataItem(getString(R.string.snacks_hot), R.drawable.snacks_hot),
                                          DataItem(getString(R.string.snacks_jewish), R.drawable.snacks_jewish),
                                          DataItem(getString(R.string.snacks_salmon), R.drawable.snacks_salmon),
                                          DataItem(getString(R.string.snacks_swedish), R.drawable.snacks_swedish)),
                      getString(R.string.categories_desserts) to listOf(DataItem(getString(R.string.desserts_keks), R.drawable.list_categories_desserts),
                                          DataItem(getString(R.string.desserts_brauni), R.drawable.desserts_brauni),
                                          DataItem(getString(R.string.desserts_pancakes), R.drawable.desserts_pancakes),
                                          DataItem(getString(R.string.desserts_tiranisu), R.drawable.desserts_tiranisu)))
        set(value) = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        val name = intent.getStringExtra("name")

        val recipes: RecyclerView = findViewById(R.id.recyclerViewRecipers)
        recipes.layoutManager = LinearLayoutManager(this)

        val adapter: CoursesAdapter? = this.recipes.get(name)?.let { CoursesAdapter(it, this) }
        recipes.adapter = adapter
    }

    override fun onCLick(dataItem: DataItem) {
        val intent = Intent(this, ContentRecipeActivity::class.java)
        intent.putExtra("name", dataItem.text)
        startActivity(intent)
    }
}