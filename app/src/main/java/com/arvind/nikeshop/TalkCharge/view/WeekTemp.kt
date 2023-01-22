package com.arvind.nikeshop.TalkCharge.view

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arvind.nikeshop.TalkCharge.TempModel
import com.arvind.nikeshop.R

@Composable
fun WeeklyYTempRow(context: Context, users: ArrayList<TempModel>) {
    val paddingModifier  = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    Card(elevation = 10.dp,
        modifier = paddingModifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            users.forEach { item ->
                WeekelyTemp(context, item)
            }
            Divider(color = Color.LightGray, thickness = 2.dp, modifier = Modifier.padding(start =10.dp, end = 10.dp))
            Row(modifier = Modifier.padding(all =20.dp), horizontalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "15 - day weather forecast",
                    fontSize = 19.sp,
                    color = Color.Black
                )
            }

        }


    }

}

@Composable
fun WeekelyTemp(context: Context, user: TempModel){
    Row(modifier = Modifier
        .padding(top = 15.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    )
    {
        Row(modifier = Modifier
            .weight(5f)
            .padding(start = 20.dp)){
            Text(text = user.day,
                textAlign = TextAlign.Start,
                fontSize = 19.sp,
                color = Color.Black)
        }
        Row(modifier = Modifier.weight(4f))
        {
            Image(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .size(30.dp, 30.dp),
                painter = painterResource(id = user.imgUrl),
                contentDescription = stringResource(id = R.string.product_text_description),
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.lighting(Color.LightGray, Color.Blue),
            )
            user.daydesc.let {
                Text(text = buildAnnotatedString {
                    append(it)
                    withStyle( SpanStyle(
                        baselineShift = BaselineShift.Superscript,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                    ) {
                        append("")
                    }
                },
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    fontSize = 19.sp,
                    color = Color.Black) }
        }
        Row(modifier = Modifier
            .padding(end = 10.dp)
            .weight(4f),horizontalArrangement = Arrangement.End) {
            user.tempUper.let {
                Text(text = buildAnnotatedString {
                    append(it.toString())
                    withStyle( SpanStyle(
                        baselineShift = BaselineShift.Superscript,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                    ) {
                        append("o")
                    }
                },

                    textAlign = TextAlign.Start,
                    fontSize = 19.sp,
                    color = Color.Black,) }
            Divider(color = Color.LightGray, modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxHeight()
                .width(2.dp)
                .height(20.dp), thickness = 2.dp)
            user.tempLower.let {
                Text(text = buildAnnotatedString {
                    append(it.toString())
                    withStyle( SpanStyle(
                        baselineShift = BaselineShift.Superscript,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                    ) {
                        append("o")
                    }
                },
                    textAlign = TextAlign.Start,
                    fontSize = 19.sp,
                    color = Color.Black) }
        }

    }

}