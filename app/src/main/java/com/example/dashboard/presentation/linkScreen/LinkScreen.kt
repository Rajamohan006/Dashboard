package com.example.dashboard.presentation.linkScreen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.dashboard.BottomNavigationBar
import com.example.dashboard.R
import com.example.dashboard.Resource
import com.example.dashboard.presentation.components.Details
import com.example.dashboard.presentation.components.LineChart
import com.example.dashboard.presentation.components.Property1Default
import com.example.dashboard.presentation.components.TopAppBar


@Composable
fun LinkScreen(
    modifier: Modifier = Modifier,

) {
    val viewModel: LinkScreenViewModel = viewModel()

    val navController = rememberNavController()
    val scrollState = rememberScrollState()
    val linkState by viewModel.links.observeAsState(Resource.Loading())
    val data= listOf(
        "January" to 45,
        "February" to 32,
        "March" to 67,
        "April" to 21,
        "May" to 89,
        "June" to 58,
    )
    when (val result = linkState) {
        is Resource.Loading -> CircularProgressIndicator()
        is Resource.Success -> {
            Scaffold(
                topBar = { TopAppBar() },
                bottomBar = { BottomNavigationBar(navController = navController) }
            ) { innerPadding ->
                Box(
                    modifier = modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(16.dp)
                        .offset(
                            x = 0.dp,
                            y = 100.dp
                        )
                        .requiredHeight(height = 1918.dp)
                        .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                        .background(color = Color(0xfff5f5f5))
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 16.dp,
                                y = 132.dp
                            )
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
                        ) {
                            Text(
                                text = "Good morning",
                                color = Color(0xff999ca0),
                                lineHeight = 1.5.em,
                                style = TextStyle(
                                    fontSize = 16.sp
                                ),
                                modifier = Modifier
                                    .wrapContentHeight(align = Alignment.CenterVertically)
                            )
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Ajay Manva",
                                    color = Color.Black,
                                    lineHeight = 1.33.em,
                                    style = MaterialTheme.typography.headlineSmall,
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically)
                                )
                                Property1Default()
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(height = 200.dp)
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(color = Color.White)
                            ) {
                                Row {
                                    Text(
                                        text = "Overview",
                                        color = Color(0xff999ca0),
                                        lineHeight = 1.43.em,
                                        style = TextStyle(
                                            fontSize = 14.sp
                                        ),
                                        modifier = Modifier
                                            .offset(
                                                x = 12.dp,
                                                y = 16.dp
                                            )
                                            .wrapContentHeight(align = Alignment.CenterVertically)
                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(
                                            4.dp,
                                            Alignment.CenterHorizontally
                                        ),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .offset(
                                                x = 193.dp,
                                                y = 12.dp
                                            )
                                            .clip(shape = RoundedCornerShape(6.dp))
                                            .border(
                                                border = BorderStroke(1.dp, Color(0xffebebeb)),
                                                shape = RoundedCornerShape(6.dp)
                                            )
                                            .padding(
                                                start = 8.dp,
                                                end = 4.dp,
                                                top = 6.dp,
                                                bottom = 6.dp
                                            )
                                    ) {
                                        Text(
                                            text = "22 Aug - 23 Sept",
                                            color = Color.Black,
                                            lineHeight = 1.em,
                                            style = TextStyle(
                                                fontSize = 12.sp
                                            ),
                                            modifier = Modifier
                                                .requiredWidth(width = 91.dp)
                                                .requiredHeight(height = 11.dp)
                                                .wrapContentHeight(align = Alignment.CenterVertically)
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.clock),
                                            contentDescription = "Time",
                                            modifier = Modifier
                                                .requiredSize(size = 16.dp)
                                        )
                                    }


                                }
                                LineChart(
                                    data = data
                                )

                            }
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(
                                    16.dp,
                                    Alignment.Start
                                ),
                                modifier = Modifier.horizontalScroll(scrollState)
                            )
                            {
                                Details(
                                    icon = painterResource(id = R.drawable.software),
                                    text1 = "123",
                                    text2 = "Today's clicks"
                                )
                                Details(
                                    icon = painterResource(id = R.drawable.pin),
                                    text1 = "Ahamedab..",
                                    text2 = "Top Location"
                                )
                                Details(
                                    icon = painterResource(id = R.drawable.generic),
                                    text1 = "Instagram",
                                    text2 = "Top source"
                                )
                                Details(
                                    icon = painterResource(id = R.drawable.software1),
                                    text1 = "11:00 - 12:00",
                                    text2 = "Best Time"
                                )
                                Analytics()


                            }


                        }
                    }

                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.Top),
                    modifier = Modifier
                        .verticalScroll(scrollState)
                        .offset(
                            x = 16.dp,
                            y = 664.dp
                        )
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .requiredWidth(width = 328.dp)
                            .requiredHeight(height = 36.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(
                                    24.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(
                                        10.dp,
                                        Alignment.Start
                                    ),
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(18.dp))
                                        .background(color = Color(0xff0e6fff))
                                        .padding(
                                            horizontal = 16.dp,
                                            vertical = 6.dp
                                        )
                                ) {
                                    Text(
                                        text = "Top Links",
                                        color = Color.White,
                                        lineHeight = 1.5.em,
                                        style = TextStyle(
                                            fontSize = 16.sp
                                        ),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically)
                                    )
                                }
                                Text(
                                    text = "Recent Links",
                                    color = Color(0xffebebeb),
                                    lineHeight = 1.5.em,
                                    style = TextStyle(
                                        fontSize = 16.sp
                                    ),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically)
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .requiredWidth(width = 36.dp)
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .background(color = Color(0xfff2f2f2))
                                    .border(
                                        border = BorderStroke(1.dp, Color(0xffebebeb)),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .padding(all = 6.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.search__stroke_),
                                    contentDescription = "Generic",
                                    tint = Color(0xff999ca0)
                                )

                            }

                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top)
                    ) {
                        Linkes(
                            linkName = "Sample link name...",
                            date = "22 Aug 2022",
                            views = "2323",
                            clickstext = "Clicks",
                            link = "https://samplelink.oia.bio/ashd..."

                        )
                        Linkes(
                            linkName = "Sample link name...",
                            date = "22 Aug 2022",
                            views = "2323",
                            clickstext = "Clicks",
                            link = "https://samplelink.oia.bio/ashd..."
                        )
                        Linkes(
                            linkName = "Sample link name...",
                            date = "22 Aug 2022",
                            views = "2323",
                            clickstext = "Clicks",
                            link = "https://samplelink.oia.bio/ashd..."
                        )
                        Linkes(
                            linkName = "Sample link name...",
                            date = "22 Aug 2022",
                            views = "2323",
                            clickstext = "Clicks",
                            link = "https://samplelink.oia.bio/ashd..."
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(
                                12.dp,
                                Alignment.CenterHorizontally
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .requiredWidth(width = 328.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .border(
                                    border = BorderStroke(1.dp, Color(0xffd8d8d8)),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(
                                    horizontal = 12.dp,
                                    vertical = 8.dp
                                )
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.link),
                                contentDescription = "Mail",
                                modifier = Modifier
                                    .requiredSize(size = 32.dp)
                            )
                            Text(
                                text = "View all Links",
                                color = Color.Black,
                                lineHeight = 1.5.em,
                                style = TextStyle(
                                    fontSize = 16.sp
                                ),
                                modifier = Modifier
                                    .wrapContentHeight(align = Alignment.CenterVertically)
                            )
                        }

                    }

                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                    modifier = Modifier

                        .offset(
                            x = 16.dp,
                            y = 1360.dp
                        )
                ) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xff4ad15f).copy(alpha = 0.12f),
                        border = BorderStroke(1.dp, Color(0xff4ad15f).copy(alpha = 0.32f)),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(8.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 328.dp)
                                .requiredHeight(height = 64.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(
                                    12.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .align(alignment = Alignment.TopStart)
                                    .offset(
                                        x = 12.dp,
                                        y = 20.dp
                                    )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.group_7563),
                                    contentDescription = "Group 7566",
                                    colorFilter = ColorFilter.tint(Color(0xff4ad15f)),
                                    modifier = Modifier
                                        .requiredSize(size = 24.dp)
                                )
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
                                ) {
                                    Text(
                                        text = "Talk with us",
                                        color = Color.Black,
                                        lineHeight = 1.5.em,
                                        style = TextStyle(
                                            fontSize = 16.sp
                                        ),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically)
                                    )
                                }
                            }
                        }
                    }
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xffe8f1ff),
                        border = BorderStroke(1.dp, Color(0xff0e6fff).copy(alpha = 0.32f)),
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(8.dp))
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 328.dp)
                                .requiredHeight(height = 65.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(
                                    12.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .align(alignment = Alignment.TopStart)
                                    .offset(
                                        x = 12.dp,
                                        y = 21.dp
                                    )
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.question_mark),
                                    contentDescription = "Group 7566",
                                    modifier = Modifier
                                        .requiredSize(size = 24.dp)
                                )
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
                                ) {
                                    Text(
                                        text = "Frequently Asked Questions",
                                        color = Color.Black,
                                        lineHeight = 1.5.em,
                                        style = TextStyle(
                                            fontSize = 16.sp
                                        ),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically)
                                    )
                                }
                            }
                        }
                    }
                }

            }
        }
        is Resource.Error -> Text("Error: ${result.message}")
        is Resource.Unauthorized -> Text("Unauthorized. Please login again.")
   }
}




@Composable
fun Analytics(){
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .requiredWidth(width = 328.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .border(
                border = BorderStroke(1.dp, Color(0xffd8d8d8)),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                horizontal = 12.dp,
                vertical = 8.dp
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrows),
            contentDescription = "Arrows",
            modifier = Modifier
                .requiredSize(size = 32.dp))
        Text(
            text = "View Analytics",
            color = Color.Black,
            lineHeight = 1.5.em,
            style = TextStyle(
                fontSize = 16.sp),
            modifier = Modifier
                .wrapContentHeight(align = Alignment.CenterVertically))
    }

}






@Composable
fun Linkes(
    linkName:String,
    date:String,
    views:String,
    clickstext:String,
    link:String
){
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
            modifier = Modifier
                .requiredWidth(width = 328.dp)
                .requiredHeight(height = 116.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(width = 328.dp)
                    .requiredHeight(height = 116.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = Color.White)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(
                            x = 12.dp,
                            y = 12.dp
                        )
                        .requiredWidth(width = 304.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .requiredWidth(width = 304.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            OutlinedTextField(
                                value = "",
                                onValueChange = {},
                                modifier = Modifier
                                    .requiredSize(size = 48.dp))
                            Column(
                                verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Top)
                            ) {
                                Text(
                                    text = linkName,
                                    color = Color.Black,
                                    lineHeight = 1.71.em,
                                    style = TextStyle(
                                        fontSize = 14.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = date,
                                        color = Color(0xff999ca0),
                                        lineHeight = 1.5.em,
                                        style = TextStyle(
                                            fontSize = 12.sp),
                                        modifier = Modifier
                                            .wrapContentHeight(align = Alignment.CenterVertically))
                                }
                            }
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically),
                            horizontalAlignment = Alignment.End
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = views,
                                    color = Color.Black,
                                    textAlign = TextAlign.End,
                                    lineHeight = 1.71.em,
                                    style = TextStyle(
                                        fontSize = 14.sp),
                                    modifier = Modifier
                                        .wrapContentHeight(align = Alignment.CenterVertically))
                            }
                            Text(
                                text = clickstext,
                                color = Color(0xff999ca0),
                                lineHeight = 1.5.em,
                                style = TextStyle(
                                    fontSize = 12.sp),
                                modifier = Modifier
                                    .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(
                            x = 0.dp,
                            y = 76.dp
                        )
                        .requiredWidth(width = 328.dp)
                        .requiredHeight(height = 40.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 328.dp)
                            .requiredHeight(height = 40.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 328.dp)
                                .requiredHeight(height = 40.dp)
                                .clip(
                                    shape = RoundedCornerShape(
                                        bottomStart = 8.dp,
                                        bottomEnd = 8.dp
                                    )
                                )
                                .background(color = Color(0xffe8f1ff))
                                .border(
                                    border = BorderStroke(1.dp, Color(0xffa6c7ff)),
                                    shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                                ))
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 12.dp,
                                    y = 8.dp
                                )
                                .requiredWidth(width = 304.dp)
                                .requiredHeight(height = 24.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = link,
                                    color = Color(0xff0e6fff),
                                    lineHeight = 1.14.em,
                                    style = TextStyle(
                                        fontSize = 14.sp),
                                    modifier = Modifier
                                        .requiredWidth(width = 213.dp)
                                        .requiredHeight(height = 11.dp)
                                        .wrapContentHeight(align = Alignment.CenterVertically)
                                        .clickable { }
                                )
                            }
                            Icon(
                                painter = painterResource(id = R.drawable.copy),
                                contentDescription = "Files")
                        }
                    }
                }
            }
        }
}

