package com.plcoding.bookpedia.book.domain


//domain model
data class Book(
    val id: String,
    val title: String,
    val imgUrl: String,
    val authors: List<String>,
    val descriptions: String?,
    val languages: List<String>,
    val firstPublishYear: String?,
    val ratingCount: Int?,
    val numPages: Int?,
    val numEditions: Int
)
