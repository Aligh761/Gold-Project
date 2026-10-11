package ali.ghanbariyan.goldproject.remote.api.goldApi

import ali.ghanbariyan.goldproject.remote.model.goldModel.GoldModel


interface GoldRequest {

    fun onSuccess(data : GoldModel)

    fun onNotSuccess(message : String)

    fun onError(error : String)
}