package com.keepcoding.finalproject.utils

import java.text.SimpleDateFormat

fun convertBooleanToInt(intFav: Int): Boolean{
    var boolFav = false
    if(intFav == 1) boolFav = true
    return boolFav
}

fun mapValue(value: Double): Double {
    val fromRange = 1..10
    val toRange = 1..5
    val fromSize = fromRange.last - fromRange.first
    val toSize = toRange.last - toRange.first
    val scaledValue = (value - fromRange.first) * toSize / fromSize
    return scaledValue + toRange.first
}

fun extractYearFromDate(dateAsString: String): String? {
    val formatFromApi = SimpleDateFormat("dd/MM/yyyy")
    val myFormat = SimpleDateFormat("yyyy")
    return formatFromApi.parse(dateAsString)?.let { date ->
        myFormat.format(date)
    }
}

fun convertACROtoString(acro: String): String{
    return when(acro){
        "us" -> "English"
        "es" -> "Spanish"
        else -> {"N/A"}
    }

}

fun joinToString(list: List<String>): String{
    return list.joinToString(", ")
}