package com.example.dognavigationexample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.dognavigationexample.presentation.detail.DetailScreen
import com.example.dognavigationexample.presentation.list.ListScreen
import com.example.dognavigationexample.presentation.start.StartScreen
import com.example.dognavigationexample.util.Constants.AGE
import com.example.dognavigationexample.util.Constants.DESC
import com.example.dognavigationexample.util.Constants.IMAGE
import com.example.dognavigationexample.util.Constants.NAME
import com.example.dognavigationexample.util.Constants.NOTE_ID
import com.example.dognavigationexample.util.Constants.SEX

@Composable
fun NavSetup(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Start.route){
        composable(Screen.Start.route){
            StartScreen(navController)
        }
        composable(
            route = Screen.List.route,
            arguments = listOf(
                navArgument(NOTE_ID){
                    type = NavType.StringType
                }
            )
        ){
            val id = it.arguments?.getString(NOTE_ID)
            ListScreen(id ?: "error",navController)
        }
        composable(
            route =Screen.Detail.route,
            arguments = listOf(
                navArgument(NAME){
                    type= NavType.StringType
                },
                navArgument(AGE){
                    type= NavType.StringType
                },
                navArgument(DESC){
                    type= NavType.StringType
                },
                navArgument(SEX){
                    type= NavType.StringType
                },
                navArgument(IMAGE){
                    type= NavType.StringType
                }
            )
        ){
            val name = it.arguments?.getString(NAME).toString()
            val age = it.arguments?.getString(AGE).toString()
            val desc = it.arguments?.getString(DESC).toString()
            val sex = it.arguments?.getString(SEX).toString()
            val image = it.arguments?.getString(IMAGE).toString()
            DetailScreen(
                name = name,
                age = age,
                desc = desc,
                sex = sex,
                image = image
            )
        }
    }
}