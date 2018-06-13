package fogarty.ryan.loginscreen.network.model.account

data class BrightHRPostValidateUserResponse(
    val companyId: Int,
    val userId: Int,
    val companyTimeZoneName: String,
    val userTimeZoneName: String,
    val token: BrightHRAccountToken,
    val hasFixedWorkingTimePattern: Boolean
)