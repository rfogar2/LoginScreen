package fogarty.ryan.loginscreen.network.services

import fogarty.ryan.loginscreen.network.model.account.BrightHRPostValidateUserResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BrightHRAccountService {
    @POST("/api/Account/PostValidateUser")
    @FormUrlEncoded
    fun postValidateUser(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<BrightHRPostValidateUserResponse>
}