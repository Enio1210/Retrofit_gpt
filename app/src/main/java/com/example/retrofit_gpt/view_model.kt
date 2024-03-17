package com.example.retrofit_gpt

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VersiculoViewModel : ViewModel() {

    /*
     fun nowPlayi() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _isLoading.postValue(true)

                val response = RetrofitConfig.filmeService.getNowPlay(Constantes.API_Key)
                withContext(Dispatchers.Main) {
                    response.body()?.let { filmes ->
                        Log.d("NowPlaying", "Número de filmes recebidos: ${filmes.resultado.size}")
                        _listNowPlay.value = filmes.resultado.sortedByDescending { it.starRate }
                        _isLoading.value = false
                    }
                }
            } catch (e: Exception) {
                // Tratar exceção, por exemplo, exibir mensagem de erro
                e.printStackTrace()
                _isLoading.value = false

     */
    private val _versiculos = MutableLiveData<List<Bible_Model>>()
    val versiculos: LiveData<List<Bible_Model>> get() = _versiculos

    fun carregarVersiculos() {
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val response = RetrofitConfig.apiService.obterDados(constantes.API_Key)
                withContext(Dispatchers.Main){
                    response.body()?.let{livro->
                        _versiculos.value = livro
                    }
                }
                if (response.isSuccessful) {
                    _versiculos.postValue(response.body())
                } else {
                    // Tratar erro de resposta, se necessário
                }
            } catch (e: Exception) {
                // Tratar exceção, se ocorrer
                Log.e("ViewModel", "Erro na chamada da API: ${e.message}")

            }
        }
    }
}
