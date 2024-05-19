package com.example.safeargsnavigationcompose_280_beta01.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.safeargsnavigation.navigation.CustomNavType
import com.example.safeargsnavigation.navigation.Screens
import com.example.safeargsnavigation.navigation.UserData
import com.example.safeargsnavigationcompose_280_beta01.view.ScreenA
import com.example.safeargsnavigationcompose_280_beta01.view.ScreenB
import com.example.safeargsnavigationcompose_280_beta01.view.ScreenC
import kotlin.reflect.typeOf

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.ScreenA) {
        composable<Screens.ScreenA> {
            ScreenA(
                screenBNavigation = {
                    navController.navigate(
                        Screens.ScreenB(userName = "Raghu", age = 20)
                    )
                }
            )
        }

        composable<Screens.ScreenB> { entry ->
            //to route method helps us to get the data that we passed earlier
            //Let's try
            //Now let's move to how to pass parcelize data
            ScreenB(
                screenANavigation = { navController.navigate(Screens.ScreenA) },
                args = entry.toRoute<Screens.ScreenB>(),
                screenCNavigation = {
                    navController.navigate(
                        Screens.ScreenC(
                            UserData(name = "Raghu", age = 20, phone = "90909")
                        )
                    )
                }
            )
        }

        composable<Screens.ScreenC>(
            typeMap = mapOf(typeOf<UserData>() to CustomNavType)
        ) { entry ->
            ScreenC(
                args = entry.toRoute<Screens.ScreenC>() // sorry forget to add this nav button in screen B
            )
        }
    }
}

