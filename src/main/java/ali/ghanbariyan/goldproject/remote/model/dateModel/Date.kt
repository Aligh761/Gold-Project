package ali.ghanbariyan.goldproject.remote.model.dateModel

import com.google.gson.annotations.SerializedName

data class Date(

    @SerializedName("F") val F_value_date: String,
    @SerializedName("Y") val Y_value_date: String,
    @SerializedName("j") val j_value_date: String,
    @SerializedName("l") val l_value_date: String
)