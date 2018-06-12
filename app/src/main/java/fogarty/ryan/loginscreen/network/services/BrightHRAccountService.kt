package fogarty.ryan.loginscreen.network.services

import fogarty.ryan.loginscreen.network.model.account.BrightHRPostValidateUserRequest
import fogarty.ryan.loginscreen.network.model.account.BrightHRPostValidateUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BrightHRAccountService {
    @POST("/api/Account/PostValidateUser")
    @FormUrlEncoded
    fun postValidateUser(
        @Body postValidateUserRequest: BrightHRPostValidateUserRequest
    ): Call<BrightHRPostValidateUserResponse>
}