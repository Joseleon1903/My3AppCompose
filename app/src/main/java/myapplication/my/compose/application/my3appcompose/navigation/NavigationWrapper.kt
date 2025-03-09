package myapplication.my.compose.application.my3appcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import myapplication.my.compose.application.my3appcompose.world.GuestWorldScreen


@Composable
fun NavigationWrapper (){

    val navController =  rememberNavController()

    NavHost( navController = navController, startDestination = Home){

        composable<Home> {
            HomeScreen{
                navController.navigate(GuestWorld)
            }
        }

        composable<GuestWorld> {
            GuestWorldScreen()
        }

    }





}
