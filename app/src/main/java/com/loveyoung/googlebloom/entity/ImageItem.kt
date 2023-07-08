package com.loveyoung.googlebloom.entity

import androidx.compose.foundation.Image
import com.loveyoung.googlebloom.R

data class ImageItem(val name:String,val resID:Int)

val bloomBannerList = listOf<ImageItem>(
    ImageItem("Desert chic", R.drawable.desert_chic),
    ImageItem("Tiny terrariums",R.drawable.tiny_terrariums),
    ImageItem("Jungle Vibes",R.drawable.jungle_vibes)
)

val bloomInfoList = listOf<ImageItem>(
    ImageItem("Monstera",R.drawable.monstera),
    ImageItem("Aglaonema",R.drawable.aglaonema),
    ImageItem("Peace lily",R.drawable.peace_lily),
    ImageItem("Fiddle leaf tree",R.drawable.fiddle_leaf),
    ImageItem("Desert chic",R.drawable.desert_chic),
    ImageItem("Tiny terrariums",R.drawable.tiny_terrariums),
    ImageItem("Jungle Vibes",R.drawable.jungle_vibes)
)

val navList = listOf<ImageItem>(
    ImageItem("Home",R.drawable.ic_home),
    ImageItem("Favorites",R.drawable.ic_favorite),
    ImageItem("Profile",R.drawable.ic_account_circle),
    ImageItem("Cart",R.drawable.ic_shopping_cart),)
