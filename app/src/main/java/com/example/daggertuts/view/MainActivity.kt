package com.example.daggertuts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.daggertuts.DataAdapter
import com.example.daggertuts.R
import com.example.daggertuts.model.Article
import com.example.daggertuts.viewmodel.NetworkViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: NetworkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Log.d("testString",myString)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        val adapter = DataAdapter(this)
        recyclerView.adapter = adapter

        // Create the observer which updates the UI.
        val dataObserver = Observer<List<Article>> { article ->
            if(article.isNotEmpty()){
                adapter.setItems(article)
            }else{
                Toast.makeText(this,"No articles matching bitcoin topic",Toast.LENGTH_LONG).show()
            }
        }
        // Observe the LiveData
        viewModel.getData()

        viewModel.data.observe(this, dataObserver)
    }
}