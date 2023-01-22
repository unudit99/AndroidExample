package com.arvind.nikeshop.TalkCharge.view

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arvind.nikeshop.R
import com.arvind.nikeshop.view.slider.NaturalModel

@Composable
fun TempData(context: Context, users: ArrayList<NaturalModel>) {
    androidx.compose.foundation.lazy.LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(items = users, itemContent = { item ->
            ListItem(context, item)
        })
    }
}

@Composable
fun ListItem(context: Context, user: NaturalModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(all = 8.dp),
    )
    {
        Text(text = user.title,
            modifier = Modifier.padding(all = 4.dp),
            textAlign = TextAlign.Start,
            fontSize = 19.sp,
            color = Color.Black)
        Image(
            modifier = Modifier
                .padding(top = 10.dp)
                .size(30.dp, 30.dp),
            painter = painterResource(id = user.imgUrl),
            contentDescription = stringResource(id = R.string.product_text_description),
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.lighting(Color.LightGray, Color.Blue),
        )
        user.desc.let {
            Text(text = buildAnnotatedString {
                append(it)
                withStyle( SpanStyle(
                    baselineShift = BaselineShift.Superscript,
                    fontSize = 12.sp,
                    color = Color.Black
                )
                ) {
                    append("o")
                }
            },
                modifier = Modifier.padding(all = 10.dp),
                textAlign = TextAlign.Start,
                fontSize = 19.sp,
                color = Color.Black) }

    }
}