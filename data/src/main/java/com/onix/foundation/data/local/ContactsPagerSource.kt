package com.onix.foundation.data.local

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.onix.foundation.domain.model.Contact

class ContactsPagerSource(
    private val localDataSource: ContactsLocalDataSource,
) : PagingSource<Int, Contact>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Contact> {
        try {
            val page = params.key ?: 1
            val nextPage = page + 1

            val response = localDataSource.getByPage(page)

            Log.d("PAGER", "$page")

            return LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Contact>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}