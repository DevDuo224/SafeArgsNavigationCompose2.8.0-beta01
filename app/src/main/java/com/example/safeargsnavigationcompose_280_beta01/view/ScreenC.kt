package com.example.safeargsnavigationcompose_280_beta01.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.safeargsnavigation.navigation.Screens

@Composable
fun ScreenC(
    modifier: Modifier = Modifier,
    args: Screens.ScreenC
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        args.let {
//            Text(text = "Object ${args.userData.toString()}")
            Text(text = "user name = ${args.userData.name} age = ${args.userData.age} ph = ${args.userData.phone}")
        }
    }
}