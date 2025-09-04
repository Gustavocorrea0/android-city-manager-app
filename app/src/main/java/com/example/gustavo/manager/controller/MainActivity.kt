package com.example.gustavo.manager.controller

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gustavo.manager.R
import com.example.gustavo.manager.databinding.ActivityMainBinding
import com.example.gustavo.manager.model.DataStore
import com.example.gustavo.manager.view.CityAdapter

class MainActivity : AppCompatActivity() {

    // 1:23:26 MIN

    private lateinit var binding: ActivityMainBinding // novo
    private lateinit var adater: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // novo
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
            adater = CityAdapter(DataStore.cities)
            binding.rcvCities.adapter = adater // populando a recicle view com dados
        }

    }
}