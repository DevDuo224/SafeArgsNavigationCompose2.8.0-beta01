package com.example.safeargsnavigationcompose_280_beta01.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.safeargsnavigation.navigation.Screens

@Composable
fun ScreenB(
    modifier: Modifier = Modifier,
    screenANavigation:()->Unit,
    screenCNavigation:()->Unit,
    args:Screens.ScreenB,

) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {
                screenANavigation()
            }
        ) {
            Text(text = "Go to Screen A")
        }

       args.let {
           Text(text = "name = ${it.userName} age= ${it.age}")
       }


        Button(
            onClick = {screenCNavigation()}
        ) {
            Text(text = "Go to Screen C with custom objects")
        }
    }
}