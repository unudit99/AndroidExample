package com.arvind.nikeshop.view
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arvind.nikeshop.R
import com.arvind.nikeshop.ui.theme.titleTextColor
import com.arvind.nikeshop.view.slider.NaturalModel
import com.arvind.nikeshop.TalkCharge.TempModel
import com.arvind.nikeshop.TalkCharge.view.BottomCard
import com.arvind.nikeshop.TalkCharge.view.GridViewData
import com.arvind.nikeshop.TalkCharge.view.TempData
import com.arvind.nikeshop.TalkCharge.view.WeeklyYTempRow


@Preview(showBackground = true)
@Composable
fun Weather(){
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    Scaffold(
        Modifier.background(Color.LightGray),
        topBar = {
                 Row(modifier = Modifier
                     .fillMaxWidth()
                     .padding(top = 20.dp, bottom = 10.dp),
                     horizontalArrangement = Arrangement.SpaceBetween,
                     verticalAlignment = Alignment.Top) {
                     Text(
                         modifier =Modifier.padding( start = 25.dp, top=20.dp, end =20.dp),
                         text = "Tikri",
                         fontWeight = FontWeight.Bold,
                         fontSize = 16.sp,
                         color = titleTextColor
                     )
                     Icon(
                         modifier =Modifier.padding( top=20.dp, end =20.dp),
                         imageVector = Icons.Default.Menu,
                         contentDescription = ""
                     )
                 }
        },
    content ={
            Box(modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize()
                .padding(top = 10.dp)) {
                Surface(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.verticalScroll(scrollState)) {
                        Divider(color = Color.LightGray, thickness = 2.dp)
                        val users = ArrayList<NaturalModel>()
                        users.add(NaturalModel("Now", "18", R.drawable.watch))
                        users.add(NaturalModel("15:00", "17", R.drawable.watch))
                        users.add(NaturalModel("16:00", "17", R.drawable.watch))
                        users.add(NaturalModel("Now", "18", R.drawable.watch))
                        users.add(NaturalModel("15:00", "17", R.drawable.watch))
                        users.add(NaturalModel("16:00", "17", R.drawable.watch))
                        users.add(NaturalModel("Now", "18", R.drawable.watch))
                        users.add(NaturalModel("15:00", "17", R.drawable.watch))
                        users.add(NaturalModel("16:00", "17", R.drawable.watch))
                        TempData(LocalContext.current, users)
                        //weekly temp
                        val temp = ArrayList<TempModel>()
                        temp.add(TempModel("Today", "Partly Cloud", R.drawable.watch, 18, 8))
                        temp.add(TempModel("Wed", "Fog", R.drawable.watch, 18, 8))
                        temp.add(TempModel("Thur", "Fog", R.drawable.watch, 18, 8))
                        temp.add(TempModel("Fri", "Fog", R.drawable.watch, 18, 8))
                        temp.add(TempModel("Sat", "Sunny", R.drawable.watch, 18, 8))
                        temp.add(TempModel("Sun", "Sunny", R.drawable.watch, 18, 8))
                        temp.add(TempModel("Mon", "Sunny", R.drawable.watch, 18, 8))
                        WeeklyYTempRow(LocalContext.current, temp)
                        Spacer(modifier = Modifier.padding(5.dp))
                        Row(
                            modifier = Modifier.padding(all = 10.dp),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Spacer(modifier = Modifier.padding(10.dp))
                            Text(
                                text = "Weather Details",
                                fontSize = 19.sp,
                                color = Color.Gray
                            )
                        }
                        GridViewData(LocalContext.current)
                        Spacer(modifier = Modifier.padding(5.dp))
                        BottomCard()

                    }
                }


        }

    })

}




