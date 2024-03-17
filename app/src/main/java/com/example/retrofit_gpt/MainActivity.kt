package com.example.retrofit_gpt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: VersiculoViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VersiculoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar ViewModel
        viewModel = ViewModelProvider(this).get(VersiculoViewModel::class.java)

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = VersiculoAdapter(emptyList()) // Adapter vazio inicialmente
        recyclerView.adapter = adapter

        // Observar os versículos do ViewModel e atualizar o RecyclerView quando houver mudanças
        viewModel.versiculos.observe(this, { versiculos ->
            adapter.atualizarLista(versiculos)
        })

        // Carregar versículos da Bíblia
        viewModel.carregarVersiculos()
    }
}