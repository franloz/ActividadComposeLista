package com.example.actividadcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun SecondActivity(marca:String,modelo:String,url:String,talla:String){
    Column(modifier=Modifier.fillMaxSize().background(color = Color.DarkGray)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(painter = rememberImagePainter(url), contentDescription = "Imagen",
                modifier = Modifier.fillMaxWidth()
                    .height(300.dp)
                    .padding(5.dp),
                contentScale = ContentScale.FillWidth)
        }
        Row(modifier =Modifier.align(CenterHorizontally)){
            Text(
                text = "Marca: "+marca,
                color = Color.White,
                fontSize = 40.sp,
                fontFamily=FontFamily.Serif,
                )
        }
        Row(modifier =Modifier.align(CenterHorizontally)){
            Text(
                text ="Modelo: " +modelo,
                color = Color.White,
                fontSize = 40.sp,
                fontFamily=FontFamily.Serif,
                )
        }
        Row(modifier =Modifier.align(CenterHorizontally)){
            Text(
                text ="Tallas: " +talla,
                color = Color.White,
                fontSize = 40.sp,
                fontFamily=FontFamily.Serif,
            )
        }
    }




}

