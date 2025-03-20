package myapplication.my.compose.application.my3appcompose.strory

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myapplication.my.compose.application.my3appcompose.R

@Composable
fun CommentItem(commentInfo : CommentInfo) {

    var nickName by remember { mutableStateOf(commentInfo.nickname) }
    var content by remember { mutableStateOf(commentInfo.content) }
    var commentDate by remember { mutableStateOf(commentInfo.date) }
    var sex by remember { mutableStateOf(commentInfo.sex) }


    Row(
        modifier = Modifier
            .padding(start = 8.dp , end = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
            .background(Color(0xFF9C27B0), RoundedCornerShape(4.dp))
            ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        // Imagen de perfil redonda

        if(sex.equals(TextUtil.SexMale, true)){
            Image(
                painter = painterResource(id = R.drawable.male_avatar),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray, CircleShape)
            )
        }
        else{

            Image(
                painter = painterResource(id = R.drawable.female_avatar),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray, CircleShape)
            )

        }



        Spacer(modifier = Modifier.width(8.dp))

        // Columna con nombre, tiempo y comentario
        Column(modifier = Modifier.weight(1f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = nickName,
                    color = Color(0xFFFFA500), // Naranja
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )

                Text(
                    text = commentDate,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }

            Text(
                text = content,
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }

    // Línea divisoria
    HorizontalDivider(thickness = 0.5.dp, color = Color.Gray)
}