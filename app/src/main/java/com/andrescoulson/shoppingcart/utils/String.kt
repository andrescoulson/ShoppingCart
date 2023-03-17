package com.andrescoulson.shoppingcart.utils


fun String.toImageUrlW500(): String {
    return "https://image.tmdb.org/t/p/w500/$this"
}
fun String.toImageUrlOriginal(): String {
    return "https://image.tmdb.org/t/p/original/$this"
}