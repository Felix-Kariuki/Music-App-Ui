package com.flexcode.musicui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
import com.flexcode.musicui.R
import com.flexcode.musicui.ui.theme.*

@Preview(showBackground = true)
@Composable
fun HomeScreen(){
    //entire box for home that will contain other columns
    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
    ){
        Column {
            //this is where all the content / rows  is placed then below it the bottom
            //navigation bar
            GreetingSection()
            ChipSection(chips = listOf("Rock", "R n B", "Slow Jams","Hip Hop", "Bongo", "Rhumba"))
            CurrentSong()
        }

    }
}

@Composable
fun GreetingSection(
    name: String = "Felix" //parameter
){
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
        //Search Icon
        Icon(painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }

}

@Composable
fun ChipSection(
    chips: List<String>
){
    var selectedChipIndex by remember {
        mutableStateOf(0) //remove error by importing setValue and getValue
    }
    //scrollable Row LazyRow
    LazyRow {
       items(chips.size){
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
               Text(text = chips[it],color = TextWhite)
           }
       }
    }
    
}

@Composable
fun CurrentSong(
    color: Color = Color.DarkGray
){
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
        Icon(painter = painterResource(id = R.drawable.ic_music),
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
            Icon(painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }

}