package com.plcoding.bookpedia.book.presentation.book_lits

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.book.presentation.book_lits.components.BookSearchBar
import com.plcoding.bookpedia.core.presentation.DarkBlue
import org.koin.compose.viewmodel.koinViewModel


// Best Practice: Do not work with a simple screen composable, cuz if u inject viewModel in runtime (won't work in previous)
// better use like this
@Composable
fun BooListScreenRoot(
    viewModel: BookListViewModel = koinViewModel(),
    onBookClick: (Book)->Unit
){
    val state by viewModel.state.collectAsStateWithLifecycle()
    BookListScreen(
        state = state,
        onAction = { action ->
            when(action){
                is BookListAction.OnBookClick -> onBookClick(action.book)
                else -> Unit
            }
            viewModel.onAction(action)
    })
}

//Now our actual Composable is isolated => testability, viewModel reference independent
@Composable
private fun BookListScreen(
    state: BookListState,
    onAction: (BookListAction)->Unit
){
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier.fillMaxSize()
            .background(DarkBlue)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BookSearchBar(
            searchQuery = state.searchQuery,
            onSearchQueryChange = {
                onAction(BookListAction.OnSearchQueryChange(it)) //go to vm
            },
            onImeSearch = {
                keyboardController?.hide()
            },
            modifier = Modifier
                .widthIn(max  =400.dp)
                .fillMaxWidth()
                .padding(16.dp)
        )
    }

}