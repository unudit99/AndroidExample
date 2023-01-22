package com.arvind.nikeshop.TalkCharge.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arvind.nikeshop.TalkCharge.GridModel
import com.arvind.nikeshop.R

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun GridViewData(context: Context){
    var courseList: ArrayList<GridModel> = ArrayList<GridModel>()

    // on below line we are adding data to our list.
    courseList.add(GridModel(R.drawable.watch,"Feels like",18,"Feels Like","o"))
    courseList.add(GridModel(R.drawable.watch,"Feels like",18,"W wind","km/h"))
    courseList.add(GridModel(R.drawable.watch,"Feels like",18,"Humidity","%"))
    courseList.add(GridModel(R.drawable.watch,"Feels like",18,"UV","Very Weak"))
    courseList.add(GridModel(R.drawable.watch,"Feels like",18,"Visiblity","km"))
    courseList.add(GridModel(R.drawable.watch,"Feels like",18,"Pressure","hpa"),)


    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier
            .padding(10.dp)
            .height(600.dp)
    ){
        items(courseList.size) {
            Card(
                shape = RoundedCornerShape(20.dp),
                onClick = {
                    Toast.makeText(
                        context,
                        courseList[it].title+ " selected..",
                        Toast.LENGTH_SHORT
                    ).show()
                },

                // on below line we are adding padding from our all sides.
                modifier = Modifier.padding(8.dp),

                // on below line we are adding elevation for the card.
                elevation = 10.dp
            ) {
                // on below line we are creating a column on below sides.
                Column(
                    // on below line we are adding padding
                    // padding for our column and filling the max size.
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp),

                    // on below line we are adding
                    // horizontal alignment for our column
                    horizontalAlignment = Alignment.CenterHorizontally,

                    // on below line we are adding
                    // vertical arrangement for our column
                    verticalArrangement = Arrangement.Center
                ) {
                    // on below line we are creating image for our grid view item.
                    Image(
                        // on below line we are specifying the drawable image for our image.
                        painter = painterResource(id = courseList[it].imgUrl),

                        // on below line we are specifying
                        // content description for our image
                        contentDescription = "Javascript",

                        // on below line we are setting height
                        // and width for our image.
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                            .padding(5.dp)
                    )

                    // on the below line we are adding a spacer.
                    Spacer(modifier = Modifier.height(9.dp))
                    Text(text = courseList[it].weatherCondition.toString(),
                        fontSize = 14.sp,
                        color = Color.LightGray
                    )
                    Text(modifier = Modifier.padding(bottom =20.dp), text = buildAnnotatedString {
                        append(courseList[it].temp.toString())
                        withStyle( SpanStyle(
                            baselineShift = if(courseList[it].weatherMeasure== "o") {
                                BaselineShift.Superscript
                            } else BaselineShift.Subscript,
                            fontSize = 15.sp,
                            color = Color.Black
                        )
                        ) {
                            append(courseList[it].weatherMeasure)
                        }
                    },
                        textAlign = TextAlign.Start,
                        fontSize = 40.sp,
                        color = Color.Black)

                }
            }
        }
    }



}