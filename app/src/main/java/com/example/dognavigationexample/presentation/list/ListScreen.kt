package com.example.dognavigationexample.presentation.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.dognavigationexample.data.DogList

@Composable
fun ListScreen(id: String, navController: NavController) {
    LazyColumn {
        items(DogList.dogList) {

            fun fixURL(): String {
                val array = StringBuffer(it.image)
                var i = 0
                while (i < array.length) {
                    if (array[i] == '/') {
                        array.setCharAt(i, '*')
                    }

                    i += 1
                }
                return array.toString()
            }

            ListItem(
                dogModel = it,
                id = id,
                navController = navController,
                name = it.name,
                description = it.description,
                age = it.age,
                image = fixURL(),
                sexuality = it.sexuality
            )
        }
    }
}