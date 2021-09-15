package com.example.diffutils

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val repo = ProductsRepo()
    private lateinit var productAdapter: ProductAdapter
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNewStock: EditText = findViewById(R.id.etNewStock)
        val btnUpdate: Button = findViewById(R.id.btnUpdate)
        val recyclerView: RecyclerView = findViewById(R.id.mainRecyclerView)
        val list = repo.products.toMutableList()
        productAdapter = ProductAdapter(repo.products)
        database = Firebase.database.reference

        btnUpdate.setOnClickListener {

            val newStock = etNewStock.text.toString()
            list[0].stock = newStock.toInt()

            productAdapter.update(list)
            Toast.makeText(this@MainActivity, "Stock Updated.", Toast.LENGTH_SHORT).show()
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.sorting_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sort_by_id -> {
                productAdapter.update(repo.sortedById)
                true
            }
            R.id.sort_by_name -> {
                productAdapter.update(repo.sortedByName)
                true
            }
            R.id.sort_by_price -> {
                productAdapter.update(repo.sortedByPrice)
                true
            }
            R.id.sort_by_stock -> {
                productAdapter.update(repo.sortedByStock)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}