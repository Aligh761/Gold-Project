package ali.ghanbariyan.goldproject.remote.model.goldModel

data class GoldModel(
    val `data`: Data,
    val last_update: String,
    val message: String,
    val source: String,
    val success: Int
)