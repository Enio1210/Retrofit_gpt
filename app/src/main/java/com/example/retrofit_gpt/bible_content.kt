package com.example.retrofit_gpt

import com.google.gson.annotations.SerializedName

data class bible_content (
    @SerializedName("results")
    var resultado:List<Bible_Model>
)