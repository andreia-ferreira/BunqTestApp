package pt.andreia.bunqtest.model.dto.sessionServer


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserPerson(
    @Expose
    @SerializedName("address_main")
    val addressMain: AddressMain? = null,
    @Expose
    @SerializedName("address_postal")
    val addressPostal: AddressPostal? = null,
    @Expose
    @SerializedName("alias")
    val alias: List<Alia>? = null,
    @Expose
    @SerializedName("avatar")
    val avatar: Avatar? = null,
    @Expose
    @SerializedName("billing_contract")
    val billingContract: List<BillingContract>? = null,
    @Expose
    @SerializedName("country_of_birth")
    val countryOfBirth: Any? = null,
    @Expose
    @SerializedName("created")
    val created: String? = null,
    @Expose
    @SerializedName("customer")
    val customer: Customer? = null,
    @Expose
    @SerializedName("customer_limit")
    val customerLimit: CustomerLimit? = null,
    @Expose
    @SerializedName("daily_limit_without_confirmation_login")
    val dailyLimitWithoutConfirmationLogin: DailyLimitWithoutConfirmationLogin? = null,
    @Expose
    @SerializedName("date_of_birth")
    val dateOfBirth: String? = null,
    @Expose
    @SerializedName("deny_reason")
    val denyReason: Any? = null,
    @Expose
    @SerializedName("display_name")
    val displayName: String? = null,
    @Expose
    @SerializedName("document_status")
    val documentStatus: String? = null,
    @Expose
    @SerializedName("first_name")
    val firstName: String? = null,
    @Expose
    @SerializedName("gender")
    val gender: String? = null,
    @Expose
    @SerializedName("id")
    val id: Int? = null,
    @Expose
    @SerializedName("is_primary_document")
    val isPrimaryDocument: Boolean? = null,
    @Expose
    @SerializedName("joint_membership")
    val jointMembership: Any? = null,
    @Expose
    @SerializedName("language")
    val language: String? = null,
    @Expose
    @SerializedName("last_name")
    val lastName: String? = null,
    @Expose
    @SerializedName("legal_name")
    val legalName: String? = null,
    @Expose
    @SerializedName("middle_name")
    val middleName: String? = null,
    @Expose
    @SerializedName("nationality")
    val nationality: String? = null,
    @Expose
    @SerializedName("notification_filters")
    val notificationFilters: List<NotificationFilter>? = null,
    @Expose
    @SerializedName("pack_membership")
    val packMembership: Any? = null,
    @Expose
    @SerializedName("place_of_birth")
    val placeOfBirth: String? = null,
    @Expose
    @SerializedName("premium_trial")
    val premiumTrial: Any? = null,
    @Expose
    @SerializedName("public_nick_name")
    val publicNickName: String? = null,
    @Expose
    @SerializedName("public_uuid")
    val publicUuid: String? = null,
    @Expose
    @SerializedName("region")
    val region: String? = null,
    @Expose
    @SerializedName("relations")
    val relations: List<Any>? = null,
    @Expose
    @SerializedName("session_timeout")
    val sessionTimeout: Int? = null,
    @Expose
    @SerializedName("status")
    val status: String? = null,
    @Expose
    @SerializedName("sub_status")
    val subStatus: String? = null,
    @Expose
    @SerializedName("tax_resident")
    val taxResident: Any? = null,
    @Expose
    @SerializedName("updated")
    val updated: String? = null,
    @Expose
    @SerializedName("version_terms_of_service")
    val versionTermsOfService: String? = null
)