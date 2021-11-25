package com.example.actividadcompose

sealed class Screen(val route:String){//ruta de destino
    object Home: Screen (route="home_screen")
    object Second:Screen(route="second_screen/{marca}/{modelo}/{url}/{talla}"){


        fun passParametros(
            marca:String,
            modelo:String,
            url:String,
            talla:String

        ) :String {
            return "second_screen/$marca/$modelo/$url/$talla"
        }
    }
}


