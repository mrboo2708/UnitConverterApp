package com.googleapp.unitconverterapp.data

data class Conversion(
    val id : Int,
    val description : String,
    val converFrom : String,
    val converTo : String,
    val multiplyBy : Double
)
