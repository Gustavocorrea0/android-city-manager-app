package com.example.gustavo.myapplication.controller

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gustavo.myapplication.R
import com.example.gustavo.myapplication.databinding.ActivityMainBinding
import com.example.gustavo.myapplication.model.DataStore
import com.example.gustavo.myapplication.view.CityAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CityAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        LinearLayoutManager(this).also { llm ->
            llm.orientation = LinearLayoutManager.VERTICAL
            binding.rcvCities.layoutManager = llm
            adapter = CityAdapter(DataStore.cities)
            binding.rcvCities.adapter = adapter // populando a recicle view com dados
        }

    }
}