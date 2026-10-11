package ali.ghanbariyan.goldproject.remote.api.timeApi

import ali.ghanbariyan.goldproject.remote.model.dateModel.DateModel

interface TimeRequest {

    fun onSuccess(data : DateModel)

    fun onNotSuccess(message : String)

    fun onError(error : String)
}