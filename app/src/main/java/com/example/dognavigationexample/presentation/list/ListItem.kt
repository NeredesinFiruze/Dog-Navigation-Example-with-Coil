package com.example.dognavigationexample.presentation.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.dognavigationexample.data.model.DogModel
import com.example.dognavigationexample.navigation.Screen

@Composable
fun ListItem(
    dogModel: DogModel,
    id: String,
    navController: NavController,
    name: String,
    sexuality: String,
    age: String,
    description: String,
    image: String
) {
    var animated by remember{ mutableStateOf(false)}

    Card(
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 12.dp)
            .clickable {
                if (id == "go_to_ListWithDetailFragment") {
                    navController.navigate(Screen.Detail.takeDog(
                        name = name,
                        age = age,
                        desc = description,
                        sex = sexuality,
                        image = image
                    ))
                } else animated = !animated


            }
    ) {
        Column(
            modifier = Modifier
            .padding(10.dp)
        ) {
            Row{
                AsyncImage(
                    model = dogModel.image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .size(70.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = dogModel.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = dogModel.description,
                        fontSize = 20.sp
                    )
                }
            }
            AnimatedVisibility(visible = animated) {
                Column(Modifier.padding(6.dp)) {
                    Text(
                        text = "age: " + dogModel.age,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                    Divider()
                    Text(
                        text = dogModel.sexuality,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }

            }
        }
    }
}