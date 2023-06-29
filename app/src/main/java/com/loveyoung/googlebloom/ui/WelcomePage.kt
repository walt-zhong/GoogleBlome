package com.loveyoung.googlebloom.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.loveyoung.googlebloom.LoginActivity
import com.loveyoung.googlebloom.ui.theme.*

private lateinit var mAct:Activity
@Composable
fun WelcomePage(act: Activity){
    mAct = act
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
    ){
        Image(
            painter = rememberVectorPainter(
                image = ImageVector.vectorResource(id = welcomeAssets.background)
            ),
            contentDescription = "welcome page",
            modifier = Modifier.fillMaxSize()
        )

        WelcomeContent()
    }
}

@Composable
fun WelcomeContent(){
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(72.dp))
        LeafImage()
        Spacer(modifier = Modifier.height(48.dp))
        WelcomeTitle()
        Spacer(modifier = Modifier.height(40.dp))
        WelcomeButtons()
    }
}

@Composable
fun LeafImage(){
    Image(painter = rememberVectorPainter(
        image = ImageVector.vectorResource(id = welcomeAssets.illos)
    ),
        contentDescription = "welcome leaf image",
    modifier = Modifier
        .wrapContentSize()
        .padding(start = 88.dp))
}

@Composable
fun WelcomeTitle(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxWidth()) {
        Image(painter = rememberVectorPainter(
            image = ImageVector.vectorResource(id = welcomeAssets.logo)),
            contentDescription = "welcome logo",
        modifier = Modifier
            .wrapContentSize()
            .height(32.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(32.dp),
            contentAlignment = Alignment.BottomCenter){
            Text(text = "Beautiful home garden solutions",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.primary)
        }
    }
}

@Composable
fun WelcomeButtons(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .height(48.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Text(
                text = "Create account",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onSecondary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        TextButton(onClick = { goLogin(mAct) }) {
            Text(
                text = "Log in",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.primary            )
        }
    }
}

fun goLogin(act: Activity){
    val intent = Intent(act, LoginActivity::class.java)
    act.startActivity(intent)
}