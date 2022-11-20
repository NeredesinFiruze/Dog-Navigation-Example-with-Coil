package com.example.dognavigationexample.navigation

import com.example.dognavigationexample.util.Constants.AGE
import com.example.dognavigationexample.util.Constants.DESC
import com.example.dognavigationexample.util.Constants.IMAGE
import com.example.dognavigationexample.util.Constants.NAME
import com.example.dognavigationexample.util.Constants.NOTE_ID
import com.example.dognavigationexample.util.Constants.SEX


sealed class Screen(val route: String){
    object Start: Screen("start_screen")
    object Detail: Screen("detail_screen/{$NAME}/{$AGE}/{$DESC}/{$SEX}/{$IMAGE}"){
        fun takeDog(
            name:String,
            age: String,
            desc:String,
            sex: String,
            image: String
        ): String{
            return "detail_screen/$name/$age/$desc/$sex/$image"
        }
    }
    object List: Screen("list_screen/{$NOTE_ID}"){
        fun takeId(id: String):String{
            return "list_screen/$id"
        }
    }
}
