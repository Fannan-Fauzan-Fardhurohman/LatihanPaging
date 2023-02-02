package id.fannan.implementpaging.paging


import androidx.paging.PagingSource
import androidx.paging.PagingState
import id.fannan.implementpaging.model.RickyMorty
import id.fannan.implementpaging.network.remote.ApiService

class MainPagingSource
    (
    private val apiService: ApiService
) : PagingSource<Int, RickyMorty>() {

    override fun getRefreshKey(state: PagingState<Int, RickyMorty>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, RickyMorty> {

        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getAllCharacters(currentPage)
            val responseData = mutableListOf<RickyMorty>()
            val data = response.body()?.results ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}