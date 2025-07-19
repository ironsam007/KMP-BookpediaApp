package com.plcoding.bookpedia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.book.presentation.book_lits.BookListScreen
import com.plcoding.bookpedia.book.presentation.book_lits.BookListState
import com.plcoding.bookpedia.book.presentation.book_lits.components.BookSearchBar


@Preview
@Composable
private fun BookSearchBarPreview() {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color.White)
    ) {
        BookSearchBar(
            searchQuery = "",
            {},
            onImeSearch = {},
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

private val books = (1..100).map{
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

@Preview
@Composable
private fun BookListScreenPreview(){
    BookListScreen(
        state = BookListState(
            searchResult =books
        ),
        onAction = {}

    )
}