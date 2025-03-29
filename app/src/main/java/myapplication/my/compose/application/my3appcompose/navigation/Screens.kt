package myapplication.my.compose.application.my3appcompose.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object GuestWorld

@Serializable
data class Calculator(val name:String)

@Serializable
data class LongStory(val comments :String)

@Serializable
data class AddComment(val comments :String)