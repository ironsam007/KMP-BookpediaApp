package com.plcoding.bookpedia.book.presentation.book_lits

import androidx.compose.ui.graphics.colorspace.RenderIntent
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BookListViewModel: ViewModel() {
    private val _state = MutableStateFlow(BookListState())   //private mutable
    val state = _state.asStateFlow()                                // public immutable



    fun onAction(action: BookListAction){
        when(action){
            is BookListAction.OnBookClick -> {}

            is BookListAction.OnSearchQueryChange -> {
                //_state.value = _state.value.copy(searchQuery = action.query)
                // or make it thread safe with StateFlow update()
                _state.update {
                    it.copy(searchQuery = action.query)
                }
            }

            is BookListAction.OnTabSelected -> {
                _state.update{
                    it.copy(selectedTabIndex = action.index)
                }
            }
        }
    }


}