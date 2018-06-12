package fogarty.ryan.loginscreen.domain

data class ValidatedUser(
    private val companyId: Int,
    private val userId: Int,
    private val companyTimeZoneName: String,
    private val userTimeZoneName: String,
    private val token: AccountToken,
    private val hasFixedWorkingTimePattern: Boolean
)