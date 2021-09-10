package com.flexcode.musicui.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flexcode.musicui.BottomNavigationContent
import com.flexcode.musicui.Latest
import com.flexcode.musicui.R
import com.flexcode.musicui.ui.theme.*

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    //entire box for home that will contain other columns
    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
    ) {
        Column {
            //this is where all the content / rows  is placed then below it the bottom
            //navigation bar
            GreetingSection()
            ChipSection(chips = listOf("Artists", "Videos", "Playlists", "Genres", "Favourites"))
            CurrentSong()
            LatestSection(
                latestMusic = listOf(
                    Latest(
                        title = "Kenya's Best",
                        R.drawable.ic_headphone,
                        Color.Gray,

                    ),
                    Latest(
                        title = "HipHop",
                        R.drawable.ic_headphone,
                        LightGreen1
                    ),
                    Latest(
                        title = "Rap",
                        R.drawable.ic_videocam,
                        BlueViolet2
                    ),
                    Latest(
                        title = "R n B's",
                        R.drawable.ic_headphone,
                        Beige1
                    ),
                    Latest(
                        title = "Bongo",
                        R.drawable.ic_headphone,
                        OrangeYellow3
                    ),
                    Latest(
                        title = "Reggea",
                        R.drawable.ic_headphone,
                        LightGreen3
                    )
                )
            )
        }
        BottomMenu(items = listOf(
            BottomNavigationContent("Home",R.drawable.ic_home),
            BottomNavigationContent("Search",R.drawable.ic_search),
            BottomNavigationContent("Library",R.drawable.ic_library),
            BottomNavigationContent("Trending",R.drawable.ic_trending),
            BottomNavigationContent("Account",R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter))

    }
}

@Composable
fun GreetingSection(
    name: String = "Felix"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,// space btn the two composables
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good Morning $name",//first text
                style = TextStyle(
                    color = TextWhite,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = gothicA1
                )//style to text
            )
            Text(
                text = "Listen to the latest music and enjoy yourself!",//second text
                style = TextStyle(
                    color = AquaBlue,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = gothicA1
                )//style to text
            )
        }
    }

}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0) //remove error by importing setValue and getValue
    }
    //scrollable Row LazyRow
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }

}

@Composable
fun CurrentSong(
    color: Color = Color.DarkGray
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 5.dp, vertical = 20.dp)
    ) {
        //Artist Icon
        Icon(
            painter = painterResource(id = R.drawable.ic_music),
            contentDescription = "Artist Icon",
            Modifier.size(50.dp)
        )
        Column {
            Text(//first text
                text = "Such Kinda Love ft. Jovial",
                style = TextStyle(
                    color = TextWhite,
                    fontWeight = FontWeight.Bold,
                    fontFamily = gothicA1,
                    fontSize = 18.sp
                )//style to text
            )
            Text(//second text
                text = "Otile Brown",
                style = TextStyle(
                    fontFamily = gothicA1,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                ),//style to text
                color = TextWhite
            )
        }
        //Play Button
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }

}

@ExperimentalFoundationApi
@Composable
fun LatestSection(latestMusic: List<Latest>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Latest",
            style = TextStyle(
                color = TextWhite,
                fontFamily = gothicA1,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ),
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 7.5.dp,
                end = 7.5.dp,
                bottom = 100.dp
            ), //push the content to middle
            modifier = Modifier.fillMaxHeight()
        ) {
            items(latestMusic.size) {
                LatestItem(latest = latestMusic[it])
            }
        }

    }
}

@Composable
fun LatestItem(
    latest: Latest
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f) // ensure a cell is square
            .clip(RoundedCornerShape(10.dp))
            .background(latest.Color)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = latest.title,
                style = TextStyle(
                    color = TextWhite,
                    fontFamily = gothicA1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                ),
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = latest.iconId),
                contentDescription = latest.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Play",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}

@Composable
fun BottomMenu(
    items: List<BottomNavigationContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
){
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.DarkGray)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
            ) {
                selectedItemIndex = index

            }
        }

    }

}

@Composable
fun BottomMenuItem(
    item: BottomNavigationContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ){
        Box(
            contentAlignment =  Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ){
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )

        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }

}