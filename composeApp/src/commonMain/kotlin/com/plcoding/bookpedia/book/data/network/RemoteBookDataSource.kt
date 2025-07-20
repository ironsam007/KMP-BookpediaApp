package com.plcoding.bookpedia.book.data.network

import androidx.room.Query
import com.plcoding.bookpedia.book.data.dto.SearchResponseDto
import com.plcoding.bookpedia.core.domain.DataError
import com.plcoding.bookpedia.core.domain.Result

// Use this abstraction in order to not couple this data layer with presentation layer
// usually it shall be in domain, to provide the function signature, but since it has reference to DTO we keep it here
//presentation -> domain <-data
interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>
}