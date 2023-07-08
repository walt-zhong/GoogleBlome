package com.loveyoung.googlebloom.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loveyoung.googlebloom.R
import com.loveyoung.googlebloom.entity.ImageItem
import com.loveyoung.googlebloom.entity.bloomBannerList
import com.loveyoung.googlebloom.entity.bloomInfoList
import com.loveyoung.googlebloom.entity.navList

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomePage() {
    Scaffold(bottomBar = { BottomBar() }) {
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(horizontal = 16.dp)
        ) {
            SearchBar()
            BloomRowBanner()
            BloomInfoList()
        }
    }
}

@Composable
fun BottomBar() {
    BottomNavigation(
        elevation= 16.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        navList.forEach {
            BottomNavigationItem(
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        painterResource(id = it.resID),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onPrimary
                    )
                }, selected = ("Home" == it.name)
            )
        }
    }

}

@Composable
fun SearchBar() {
    Box {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(4.dp)),
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(
                        image = ImageVector.vectorResource(R.drawable.ic_search),
                    ),
                    contentDescription = "search",
                    modifier = Modifier.size(18.dp),
                    tint = Color.Gray
                )
            },
            placeholder = {
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.body1,
                    color = Color.Gray
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.White,
                unfocusedBorderColor = Color.White,// 未选中时的下边框颜色
                focusedBorderColor = Color.White // 选中时下边框颜色
            )
        )
    }

}

@Composable
fun BloomRowBanner() {
    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Browse themes",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 32.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(modifier = Modifier.height(136.dp)) {
            items(bloomBannerList.size) {
                if (it != 0) {
                    // 每个子元素之间水平间距为8.dp
                    Spacer(modifier = Modifier.width(8.dp))
                }

                PlantCard(plant = bloomBannerList[it])
            }
        }
    }

}

@Composable
fun BloomInfoList() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Design your home garden",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.paddingFromBaseline(top = 40.dp))
            Icon(painterResource(id = R.drawable.ic_filter_list),
                contentDescription = "filter",
            modifier = Modifier
                .padding(top = 24.dp)
                .size(24.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(bottom = 56.dp)){
            items(bloomInfoList.size){
                if (it != 0){
                    Spacer(modifier = Modifier.height(8.dp))
                }

                DesignCard(plant = bloomInfoList[it])
            }
        }
    }
}


@Composable
fun PlantCard(plant: ImageItem) {
    Card(
        modifier = Modifier
            .size(136.dp)
            .clip(RoundedCornerShape(4.dp))
    ) {
        Column {
            Image(
                painterResource(
                    id = plant.resID),
                contentScale = ContentScale.Crop,
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = plant.name,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                )
            }
        }
    }
}

@Composable
fun DesignCard(plant: ImageItem) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painterResource(id = plant.resID),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Column {
                    Text(
                        text = plant.name,
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )

                    Text(
                        text = "这是描述。。。。。。。",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.primary,
                    )
                }

                Checkbox(
                    checked = false, onCheckedChange = {},
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .size(24.dp),
                    colors = CheckboxDefaults.colors(checkmarkColor = Color.White)
                )

            }

            // 每个子元素下面画一根线
            Divider(
                color = Color.Gray,
                modifier = Modifier.padding(top = 16.dp),
                thickness = 0.5.dp
            )
        }
    }
}

