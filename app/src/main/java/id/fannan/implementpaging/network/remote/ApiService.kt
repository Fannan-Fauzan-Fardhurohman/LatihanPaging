package id.fannan.implementpaging.network.remote

import id.fannan.implementpaging.model.ResponseApi
import id.fannan.implementpaging.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        @Query("page") page:Int
    ):Response<ResponseApi>
}