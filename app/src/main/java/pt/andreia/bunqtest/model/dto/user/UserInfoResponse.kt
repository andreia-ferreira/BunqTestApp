package pt.andreia.bunqtest.model.dto.user


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pt.andreia.bunqtest.model.dto.Error
import pt.andreia.bunqtest.model.dto.Pagination

data class UserInfoResponse(
    @Expose
    @SerializedName("Pagination")
    val pagination: Pagination? = null,
    @Expose
    @SerializedName("Response")
    val userInfoResult: List<UserInfoResult>? = null,
    @Expose
    @SerializedName("Error")
    val error: List<Error>? = null
)