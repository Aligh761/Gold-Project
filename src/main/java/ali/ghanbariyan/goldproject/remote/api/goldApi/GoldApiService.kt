package ali.ghanbariyan.goldproject.remote.api.goldApi

import ali.ghanbariyan.goldproject.remote.model.goldModel.GoldModel
import retrofit2.Call
import retrofit2.http.GET

interface GoldApiService {
    @GET("currencies")
    fun getGold(): Call<GoldModel>
}