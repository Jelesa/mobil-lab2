package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ContentRecipeActivity : AppCompatActivity() {

    val dishes: Map<String, DataItem>
        get() = mapOf(
            getString(R.string.drinks_coconut) to (DataItem(getString(R.string.recips_coconut), R.drawable.large_coconut)),
            getString(R.string.drinks_coffee) to (DataItem(getString(R.string.recips_coffee), R.drawable.large_coffee)),
            getString(R.string.drinks_cranberry) to (DataItem(getString(R.string.recips_cranberry), R.drawable.large_cranberry)),
            getString(R.string.drinks_limonad) to (DataItem(getString(R.string.recips_limonad), R.drawable.large_limonad)),
            getString(R.string.dishes_baked_chiken) to (DataItem(getString(R.string.recips_baked_chiken), R.drawable.large_baked_chiken)),
            getString(R.string.dishes_potato) to (DataItem(getString(R.string.recips_potato), R.drawable.large_potato)),
            getString(R.string.dishes_chiken_balls) to (DataItem(getString(R.string.recips_chiken_balls), R.drawable.large_chiken_balls)),
            getString(R.string.dishes_ric_egg) to (DataItem(getString(R.string.recips_ric_egg), R.drawable.large_ric_egg)),
            getString(R.string.salads_mimoza) to (DataItem(getString(R.string.recips_mimoza), R.drawable.large_mimoza)),
            getString(R.string.salads_ceaser) to (DataItem(getString(R.string.recips_ceaser), R.drawable.large_ceaser)),
            getString(R.string.salads_gazaphuli) to (DataItem(getString(R.string.recips_gazaphuli), R.drawable.large_gazaphuli)),
            getString(R.string.salads_srimp) to (DataItem(getString(R.string.recips_srimp), R.drawable.large_srimp)),
            getString(R.string.snacks_salmon) to (DataItem(getString(R.string.recips_salmon), R.drawable.large_salmon)),
            getString(R.string.snacks_swedish) to (DataItem(getString(R.string.recips_swedish), R.drawable.large_swedish)),
            getString(R.string.snacks_hot) to (DataItem(getString(R.string.recips_hot), R.drawable.large_hot)),
            getString(R.string.snacks_jewish) to (DataItem(getString(R.string.recips_jewish), R.drawable.large_jewish)),
            getString(R.string.desserts_tiranisu) to (DataItem(getString(R.string.recips_tiranisu), R.drawable.large_tiramisu)),
            getString(R.string.desserts_pancakes) to (DataItem(getString(R.string.recips_pancakes), R.drawable.large_pancfkes)),
            getString(R.string.desserts_brauni) to (DataItem(getString(R.string.recips_brauni), R.drawable.large_brauni)),
            getString(R.string.desserts_keks) to (DataItem(getString(R.string.recips_keks), R.drawable.large_keks)))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_recipe)

        val name = intent.getStringExtra("name")

        val textName: TextView = findViewById(R.id.textName)
        val textContent: TextView = findViewById(R.id.textRecieps)
        val imagePhoto: ImageView = findViewById(R.id.photoDishes)

        textName.text = name
        textContent.text = dishes[name]?.text
        imagePhoto.setImageResource(dishes[name]?.src!!)
    }
}