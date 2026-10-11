package ali.ghanbariyan.goldproject.remote.api.timeApi

import ali.ghanbariyan.goldproject.remote.model.dateModel.DateModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TimeApiService {
    @GET("date/now")
    fun getTime(
        @Query("short") short: Boolean
    ): Call<DateModel>
}