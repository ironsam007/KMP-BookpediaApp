package com.plcoding.bookpedia.book.presentation.book_lits

import com.plcoding.bookpedia.book.domain.Book


//in MVI this could be just a sealed class encapsulate object // here: sealed interface encapsulate classes
sealed interface BookListAction {
    data class OnSearchQueryChange(val query: String): BookListAction
    data class OnBookClick(val book: Book): BookListAction
    data class OnTabSelected(val index: Int): BookListAction
}