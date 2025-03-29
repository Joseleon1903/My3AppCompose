package myapplication.my.compose.application.my3appcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import myapplication.my.compose.application.my3appcompose.calculator.CalculatorScreen
import myapplication.my.compose.application.my3appcompose.strory.AddCommentScreen
import myapplication.my.compose.application.my3appcompose.strory.CommentDatabaseManager
import myapplication.my.compose.application.my3appcompose.strory.CommentInfo
import myapplication.my.compose.application.my3appcompose.strory.LongStoryScreen
import myapplication.my.compose.application.my3appcompose.strory.TextUtil
import myapplication.my.compose.application.my3appcompose.world.GuestWorldScreen
import myapplication.my.compose.application.my3appcompose.world.UtilsWords
import java.util.Random
import kotlin.toString


@Composable
fun NavigationWrapper (){

    val navController =  rememberNavController()

    var Days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    var day = Days[Random().nextInt(Days.size)]
//    var question = UtilsWords.mixWord(day)


    NavHost( navController = navController, startDestination = Home){

        composable<Home> {
            HomeScreen{ it ->
                println("Screen name $it")
                if(it.equals(toString(), true)){
                    navController.navigate(GuestWorld)
                }else if(it.equals(Calculator.toString(), true)){
                    navController.navigate(Calculator(name = "Calculator"))
                }else if(it.equals(LongStory.toString(), true)){
                    navController.navigate(LongStory(comments = TextUtil().commentsToString(CommentDatabaseManager.get())
                    ))
                }
            }
        }

        composable<GuestWorld> {
            GuestWorldScreen(Days
            ){
                navController.popBackStack()
            }
        }

        composable<Calculator> { backStackEntry ->
            val calculatorV : Calculator = backStackEntry.toRoute()
           CalculatorScreen(calculatorV.name){
               navController.popBackStack()
           }
        }

        composable<LongStory> {

            LongStoryScreen(TextUtil().commentsToString(CommentDatabaseManager.get()), navController){
                navController.popBackStack()
            }
        }

        composable<AddComment> {
            AddCommentScreen(TextUtil().commentsToString(CommentDatabaseManager.get())){
                navController.popBackStack()
            }
        }

    }





}
