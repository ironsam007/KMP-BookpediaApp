package com.plcoding.bookpedia.book.presentation.book_lits

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.plcoding.bookpedia.book.domain.Book
import org.koin.compose.viewmodel.koinViewModel


// Best Practice: Do not work with a simple screen composable, cuz if u inject viewModel in runtime (won't work in previous)
// better use like this
@Composable
fun BooListScreenRoo(
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


}