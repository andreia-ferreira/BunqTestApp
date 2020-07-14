package pt.andreia.bunqtest.model.dto


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pagination(
    @Expose
    @SerializedName("future_url")
    val futureUrl: String? = null,
    @Expose
    @SerializedName("newer_url")
    val newerUrl: Any? = null,
    @Expose
    @SerializedName("older_url")
    val olderUrl: Any? = null
)