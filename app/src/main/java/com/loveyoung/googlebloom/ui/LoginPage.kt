package com.loveyoung.googlebloom.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loveyoung.googlebloom.ui.theme.BloomTheme
import com.loveyoung.googlebloom.ui.theme.GoogleBloomTheme

@Composable
fun LoginPage() {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 16.dp)
    ) {
        LoginTitle()
        LoginInputBox()
        LoginHintWithUnderLine();
        LoginButton()
    }
}

@Composable
fun LoginTitle() {
    Text(
        text = "Log in with email",
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(
                top = 184.dp,
                bottom = 16.dp
            ),
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.primary,
        textAlign = TextAlign.Center
    )
}

@Composable
fun LoginInputBox() {
    Column {
        LoginTextField(placeHolder = "Email address")
        Spacer(modifier = Modifier.height(8.dp))
        LoginTextField(placeHolder = "Password(8+ Characters)")
    }
}

@Composable
fun LoginTextField(placeHolder: String) {
    OutlinedTextField(value = "", onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(MaterialTheme.shapes.small)
            .border(1.dp, MaterialTheme.colors.primary),
        placeholder = {
            Text(
                text = placeHolder,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.primary
            )
        }
    )
}

@Composable
fun LoginHintWithUnderLine() {
    Column(modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp)) {
        TopText()
        BottomText()
    }
}

@Composable
fun TopText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween //设置两端对齐
    ) {
        val keyWorldPre = "By Clicking below you agree to our".split(" ")
        val keyWorldPost = "and consent".split(" ")

        for (word in keyWorldPre) {
            Text(
                text = word,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primary
            )
        }

        Text(
            text = "Terms of Use",
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.primary,
            textDecoration = TextDecoration.Underline
        )

        for (word in keyWorldPost) {
            Text(
                text = word,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primary
            )
        }
    }
}

@Composable
fun BottomText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = " to Our",
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.primary
        )

        Text(
            text = "Privacy policy.",
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun LoginButton(){
    Button(onClick = { /*TODO*/ },
    modifier = Modifier
        .height(48.dp)
        .fillMaxWidth()
        .clip(MaterialTheme.shapes.medium),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.onBackground)) {
        Text(text = "Log in", style = MaterialTheme.typography.button, color = MaterialTheme.colors.onPrimary)
    }
}

@Preview
@Composable
fun LoginPagePreview(){
    GoogleBloomTheme(
        theme = if (isSystemInDarkTheme()) BloomTheme.DARK
        else BloomTheme.LIGHT
    ) {
       LoginPage()
    }
}

