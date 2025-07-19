package com.plcoding.bookpedia

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.plcoding.bookpedia.book.presentation.book_lits.BookListScreenRoot
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.plcoding.bookpedia.book.presentation.book_lits.BookListViewModel

@Composable
@Preview
fun App() { //This is the Entry point to app on multi-Platforms
    BookListScreenRoot(
        viewModel  = remember { BookListViewModel() },
        onBookClick = {}
    )
}