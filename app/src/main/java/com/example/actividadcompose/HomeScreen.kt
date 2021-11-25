package com.example.actividadcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter

@Composable
fun HomeScreen(navController: NavController){
    var lista:MutableList<Zapatilla> = mutableListOf()
    rellenarLista(lista)

    LazyColumn(modifier= Modifier
        .fillMaxSize().background(color = Color.DarkGray)
        )

    {
        items(lista){
            Item(zapatilla = it,navController)//it hace lo mismo q coche->
        }
    }
}

@Composable
fun Item(zapatilla:Zapatilla,navController: NavController){
    var marca=zapatilla.marca
    var modelo=zapatilla.modelo
    var url=zapatilla.url
    var talla=zapatilla.talla
    Row(modifier = Modifier.fillMaxWidth().clickable {navController.navigate(Screen.Second.passParametros(marca,modelo,url,talla))}) {
        Column(modifier = Modifier.weight(2f)) {
            //meter en box

            Box(modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)){
                var url=zapatilla.url
                CargarImagen(url = url)
            }

        }
        Column(modifier = Modifier.weight(4f)) {
            Box(modifier= Modifier
                .padding(vertical = 5.dp)
                .background(color = Color.Blue)
                .fillMaxWidth()
                .height(100.dp))

            {

                Row(modifier = Modifier
                    .align(Alignment.Center))
                {
                    Text(text = zapatilla.marca,color = Color.White,style= TextStyle(fontSize = 25.sp),fontWeight = FontWeight.ExtraBold )
                }
            }
        }
    }


}
@Composable
fun rellenarLista(lista: MutableList<Zapatilla>) {
    lista.add(Zapatilla("Vans","Filmore","https:\\\\resize.sprintercdn.com\\f\\550x550\\products\\0305613\\vans-mn-filmore-decon_0305613_03_4_1753527439.jpg","36-39"))
    lista.add(Zapatilla("Adidas","Hoops","https:\\\\resize.sprintercdn.com\\f\\550x550\\products\\0315370\\adidas-hoops-2-0_0315370_03_4_2413657080.jpg","39-40"))
    lista.add(Zapatilla("Joma","Tornado","https:\\\\resize.sprintercdn.com\\f\\550x550\\products\\0319163\\joma-tornado_0319163_03_4_3150546028.jpg","36-38"))
    lista.add(Zapatilla("Converse","Classic","https:\\\\resize.sprintercdn.com\\f\\550x550\\products\\0314293\\converse-net-star-classic_0314293_00_4_1600528635.jpg","35-44"))
    lista.add(Zapatilla("Nike","Air Max","https:\\\\resize.sprintercdn.com\\f\\550x550\\products\\0320066\\nike-air-max_0320066_00_4_3981637686.jpg","41"))
    lista.add(Zapatilla("New Balance","574","https:\\\\resize.sprintercdn.com\\f\\550x550\\products\\0315948\\new-balance-ml574_0315948_00_4_4228820954.jpg","40-42"))
    lista.add(Zapatilla("Adidas","Breaknet","https:\\\\resize.sprintercdn.com\\f\\550x550\\products\\0315369\\adidas-breaknet_0315369_00_4_1023144743.jpg","34-39"))
    lista.add(Zapatilla("Puma","Retaliate","https:\\\\resize.sprintercdn.com\\f\\550x550\\products\\0313439\\puma-retaliate_0313439_02_4_956780421.jpg","36-38"))
    lista.add(Zapatilla("Nicobocco","Master 22","https:\\\\resize.sprintercdn.com\\f\\550x550\\products\\0321285\\nicobocco-master-22_0321285_03_4_4247287357.jpg","40"))
    lista.add(Zapatilla("Munich","G3 Profit","https:\\\\resize.sprintercdn.com\\f\\550x550\\products\\0318049\\munich-g3-profit_0318049_03_4_1070878756.jpg","34-36"))
    lista.add(Zapatilla("Puma","X-ray","https:\\\\resize.sprintercdn.com\\f\\550x550\\products\\0313244\\puma-x-ray-lite_0313244_00_4_434960234.jpg","36"))
}
@Composable
fun CargarImagen(url:String){
    Image(painter = rememberImagePainter(url), contentDescription = "Imagen",
        modifier = Modifier
            .height(100.dp),
        contentScale = ContentScale.FillWidth)
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewGr(){
    HomeScreen(navController= rememberNavController())
}