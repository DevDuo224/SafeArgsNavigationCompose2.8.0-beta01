package com.example.safeargsnavigationcompose_280_beta01.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.provider.FontsContractCompat.Columns

@Composable
fun ScreenA(
    modifier: Modifier = Modifier,
    screenBNavigation:()->Unit // I am writing a call back for navigation Google recommends to don't pass navController
        // instead pass call back
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {
                screenBNavigation()
            }
        ) {
            Text(text = "Go to Screen B with data")
        }
    }
}