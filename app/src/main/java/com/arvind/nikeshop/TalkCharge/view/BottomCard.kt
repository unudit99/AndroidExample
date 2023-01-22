package com.arvind.nikeshop.TalkCharge.view
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomCard(){
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(8.dp)
            .height(200.dp),
        elevation = 10.dp
    ){
        Column() {
            Row(modifier = Modifier
                .padding(top = 20.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = ""
                )
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = ""
                )

            }
            Column(
                modifier = Modifier.padding(top =70.dp),
                verticalArrangement = Arrangement.Bottom
              ){
                Row(modifier = Modifier.padding(top = 20.dp, start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Sunrise",modifier = Modifier.padding(all = 4.dp),
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        color = Color.LightGray)
                    Text(text = "Sunset",modifier = Modifier.padding(all = 4.dp),
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        color = Color.LightGray)
                }
                Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "17:22",modifier = Modifier.padding(all =2.dp),
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        color = Color.Black)
                    Text(text = "17:33",modifier = Modifier.padding(all = 4.dp),
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        color = Color.Black)
                }
            }

        }


       
}}



