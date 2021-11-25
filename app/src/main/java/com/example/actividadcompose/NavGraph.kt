package com.example.actividadcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetUpNavGraph(navController: NavHostController){
    NavHost(
        navController=navController,
        startDestination=Screen.Home .route
    )
    {
        composable(
            Screen.Home.route
        )
        {
            HomeScreen(navController=navController)
        }
        composable(
            Screen.Second.route,
            arguments=listOf(navArgument("marca"){
                type= NavType.StringType
            },
            navArgument("modelo")  {
                type= NavType.StringType
            },
            navArgument("url")  {
                type= NavType.StringType
            },
            navArgument("talla")  {
                type= NavType.StringType
            })
        ) { navBackStackEntry->
            SecondActivity(navBackStackEntry.arguments?.getString("marca")!!,
                navBackStackEntry.arguments?.getString("modelo")!!,
                navBackStackEntry.arguments?.getString("url")!!,
                navBackStackEntry.arguments?.getString("talla")!!)
        }
    }
}