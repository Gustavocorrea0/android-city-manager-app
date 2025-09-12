package com.example.gustavo.myapplication.controller

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gustavo.myapplication.R
import com.example.gustavo.myapplication.databinding.ActivityManagerBinding
import com.example.gustavo.myapplication.model.City
import com.example.gustavo.myapplication.model.DataStore
import com.google.android.material.snackbar.Snackbar

class ManagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityManagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManagerBinding.inflate(layoutInflater)

        this.configureUI()



        // funcoes dos botoes
        binding.btnSave.setOnClickListener {
            val name = binding.txtName.text.toString()
            val people = binding.txtPeople.text.toString().toIntOrNull() ?: 0 // se for nulo retorna 0
            City(name, people).also { city ->
                DataStore.addCity(city)
            }
            Intent().apply {
                this.putExtra("cityName", name)
                setResult(RESULT_OK, this)
            }
            finish()
        }

        binding.btnCancel.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }

    fun configureUI() {
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layManager)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}