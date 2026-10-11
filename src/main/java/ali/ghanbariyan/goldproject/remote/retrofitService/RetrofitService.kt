package ali.ghanbariyan.goldproject.remote.retrofitService

import ali.ghanbariyan.goldproject.remote.api.goldApi.GoldApiService
import ali.ghanbariyan.goldproject.remote.api.timeApi.TimeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val URL = "https://tools.daneshjooyar.com/api/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService : TimeApiService = retrofit.create(TimeApiService::class.java)

    val goldApiService : GoldApiService = retrofit.create(GoldApiService::class.java)
}