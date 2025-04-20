package myapplication.my.compose.application.my3appcompose.strory

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import myapplication.my.compose.application.my3appcompose.R
import myapplication.my.compose.application.my3appcompose.navigation.AddComment
import myapplication.my.compose.application.my3appcompose.navigation.CustomTopAppBar

@Composable
fun LongStoryScreen (viewModel : CommentViewModel ,  navController: NavHostController?, navigateToScreen : () -> Unit){

    val comments : List<CommentInfo> by viewModel.comments.observeAsState( initial = arrayListOf())

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {

        CustomTopAppBar("Long Story",navigateToScreen )


        // Imagen superior
        Image(
            painter = painterResource(id = R.drawable.slavery_in_america),
            contentDescription = "Cultural Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )


        Row( modifier = Modifier
            .padding(start = 8.dp, top = 5.dp)
            .height(25.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {
            // Etiqueta colorida
            Text(
                text = "Esclavismo en America",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color(0xFF9C27B0), RoundedCornerShape(4.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)

            )
        }


        // Título y hora
        Text(
            text = "EVERY CULTURE IS UNIQUE",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )

        Text(
            text = DateUtils.getFormattedDateTime(),
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        // Descripción
        Text(
            text = TextUtil.slaveryDescripctiobn,
            fontSize = 14.sp,
            modifier = Modifier.padding(8.dp)
        )

        // comments
        Spacer(modifier = Modifier.height(15.dp))


        if(!comments.isEmpty()){
            CommentList(comments =comments)
        }

//        CommentItem( CommentInfo( nickname= "App developer",
//           content ="Este es mi mejor comentario",
//            date="35 minute ago",
//            sex=TextUtil.SexMale)
//        )
//        CommentItem( CommentInfo( nickname= "App developer",
//            content ="Este es mi mejor comentario",
//            date="35 minute ago",
//            sex=TextUtil.SexFemale)
//        )


        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start){
            Button(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                onClick = { println("Press button")
                    navController?.navigate(AddComment)
                }) {
                Text("White a comment")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppMainView(){
//
//    LongStoryScreen(
//        comments = "",
//        navController = null,
//        navigateToScreen = {}
//    )

}