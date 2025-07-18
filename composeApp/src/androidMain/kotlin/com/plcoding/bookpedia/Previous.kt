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