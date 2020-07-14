package pt.andreia.bunqtest.model.dto.sessionServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NotificationFilter(
    @Expose
    @SerializedName("category")
    val category: String? = null,
    @Expose
    @SerializedName("notification_delivery_method")
    val notificationDeliveryMethod: String? = null
)