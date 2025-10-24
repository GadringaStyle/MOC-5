import java.util.UUID
import java.time.OffsetDateTime

data class CanteenData(
    val id: UUID? = null,
    val name: String,
    val dish: String,
    var dishPrice: Double,
    val averageRating: Double
)

data class CanteenDetails(
    var name: String,
    var address: String,
    var phoneNumber: String,
    var website: String,
    var dish: String,
    var dishPrice: Double,
    var waitingTime: Int? = null
)

data class CanteenReviewStatistics(
    val countOneStar: Int,
    val countTwoStars: Int,
    val countThreeStars: Int,
    val countFourStars: Int,
    val countFiveStars: Int
)

data class OwnedCanteenDetails(
    val id: UUID? = null,
    val name: String,
    val address: String,
    val phoneNumber: String,
    val website: String,
    val dish: String,
    val dishPrice: Double,
    val waitingTime: Int? = null
)

data class ReviewData(
    val id: UUID? = null,
    val creationDate: OffsetDateTime? = null,
    val creator: String,
    val rating: Int,
    val remark: String
)