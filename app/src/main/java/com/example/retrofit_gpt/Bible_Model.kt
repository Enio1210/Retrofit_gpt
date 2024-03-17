package com.example.retrofit_gpt

import com.google.gson.annotations.SerializedName

data class Bible_Model(
    @SerializedName("id")
    var id:String,
    @SerializedName("bibleId")
    var bibleId:String,
    @SerializedName("chapterId")
    var chapterId:String,
)
