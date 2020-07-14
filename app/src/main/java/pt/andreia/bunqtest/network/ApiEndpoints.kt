package pt.andreia.bunqtest.network

import pt.andreia.bunqtest.model.dto.deviceServer.DeviceServerInput
import pt.andreia.bunqtest.model.dto.deviceServer.DeviceServerResponse
import pt.andreia.bunqtest.model.dto.installation.InstallationInput
import pt.andreia.bunqtest.model.dto.installation.InstallationResponse
import pt.andreia.bunqtest.model.dto.payments.ListPaymentsResponse
import pt.andreia.bunqtest.model.dto.payments.NewRequestInquiry
import pt.andreia.bunqtest.model.dto.payments.RequestInquiryResponse
import pt.andreia.bunqtest.model.dto.payments.RequestInquiryStatusResponse
import pt.andreia.bunqtest.model.dto.sessionServer.SessionServerInput
import pt.andreia.bunqtest.model.dto.sessionServer.SessionServerResponse
import pt.andreia.bunqtest.model.dto.user.UserInfoResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiEndpoints {

    @POST("installation")
    suspend fun createInstallation(@Body input: InstallationInput): Response<InstallationResponse?>

    @POST("device-server")
    suspend fun registerDevice(@Body input: DeviceServerInput): Response<DeviceServerResponse?>

    @POST("session-server")
    suspend fun initSession(@Body input: SessionServerInput): Response<SessionServerResponse?>

    @GET("user")
    suspend fun getUserInfo(): Response<UserInfoResponse?>

    @GET("user/{userId}/monetary-account/{monetaryId}/payment")
    suspend fun getUserPayments(@Path("userId") id: Int?, @Path("monetaryId") idMoney: Int?): Response<ListPaymentsResponse?>

    @POST("user/{userId}/monetary-account/{monetaryId}/request-inquiry")
    suspend fun requestNewPayment(@Path("userId") id: Int?, @Path("monetaryId") idMoney: Int?, @Body input: NewRequestInquiry): Response<RequestInquiryResponse?>

    @GET("user/{userId}/monetary-account/{monetaryId}/request-inquiry/{paymentId}")
    suspend fun checkPaymentStatus(@Path("userId") id: Int?, @Path("monetaryId") idMoney: Int?, @Path("paymentId") idPayment: Int?): Response<RequestInquiryStatusResponse?>

}