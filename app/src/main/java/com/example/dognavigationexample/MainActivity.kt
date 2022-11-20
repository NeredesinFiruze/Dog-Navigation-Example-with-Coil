package com.example.dognavigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.dognavigationexample.navigation.NavSetup
import com.example.dognavigationexample.ui.theme.DogNavigationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogNavigationExampleTheme {
                Scaffold(
                    drawerContent = {
                        Text(text = "hello")
                    }
                ) {
                    Column(Modifier.padding(it)) {
                        NavSetup(rememberNavController())
                    }
                }

            }
        }
    }
}