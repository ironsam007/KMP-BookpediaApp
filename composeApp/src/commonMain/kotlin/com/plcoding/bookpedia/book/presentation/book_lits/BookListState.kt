package com.plcoding.bookpedia.book.presentation.book_lits

import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.core.presentation.UiText


//MVI based
data class BookListState(
    val searchQuery: String = "kotlin",
    val searchResult: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null //from core.presentation: dynaString or resourceString.. reveal the Book state
)
