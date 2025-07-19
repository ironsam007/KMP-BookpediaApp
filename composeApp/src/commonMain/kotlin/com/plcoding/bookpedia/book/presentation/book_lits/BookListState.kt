package com.plcoding.bookpedia.book.presentation.book_lits

import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.core.presentation.UiText


//MVI based
data class BookListState(
    val searchQuery: String = "kotlin",
    val searchResult: List<Book> = lbooks, //To be changed to emptyList, dummy data for tests
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null //from core.presentation: dynaString or resourceString.. reveal the Book state
)


val lbooks = (1..100).map{
    Book(
        id = it.toString(),
        title = "Book $it",
        imgUrl = "https://test.com",
        authors = listOf("Issam"),
        descriptions = "Descript $it",
        languages = emptyList(),
        firstPublishYear = null,
        averageRating = 4.432,
        ratingCount = 5,
        numPages = 100,
        numEditions = 3
    )
}