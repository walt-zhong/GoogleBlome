package com.loveyoung.googlebloom

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.loveyoung.googlebloom.base.BaseActivity
import com.loveyoung.googlebloom.ui.HomePage

class HomePageActivity : BaseActivity() {
    @Composable
    override fun LoadUI() {
        HomePage()
    }
}
