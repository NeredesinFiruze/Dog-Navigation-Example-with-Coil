package com.example.dognavigationexample.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun DetailScreen(
    name: String,
    age: String,
    desc: String,
    sex: String,
    image: String,
) {
    fun fixURL(): String {
        val array = StringBuffer(image)
        var i = 0
        while (i < array.length) {
            if (array[i] == '*') {
                array.setCharAt(i, '/')
            }

            i += 1
        }
        return array.toString()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = fixURL(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 20.dp)
                .clip(RoundedCornerShape(16.dp))
                .size(270.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = name,
            fontSize = 35.sp,
            modifier = Modifier
                .padding(8.dp),
            fontWeight = FontWeight.Bold
        )
        Divider(Modifier.padding(4.dp))
        Text(
            text = desc,
            fontSize = 35.sp,
            modifier = Modifier
                .padding(8.dp),
        )
        Divider(Modifier.padding(4.dp))
        Text(
            text = "age: $age",
            fontSize = 35.sp,
            modifier = Modifier
                .padding(8.dp),
        )
        Divider(Modifier.padding(4.dp))
        Text(
            text = sex,
            fontSize = 35.sp,
            modifier = Modifier
                .padding(8.dp),
        )
    }
}











