package fogarty.ryan.loginscreen.network.model.account

import fogarty.ryan.loginscreen.domain.Transformable
import fogarty.ryan.loginscreen.domain.ValidatedUser
import fogarty.ryan.loginscreen.network.validation.BrightHRMissingPropertyException

data class BrightHRPostValidateUserResponse(
    private val companyId: Int? = null,
    private val userId: Int? = null,
    private val companyTimeZoneName: String? = null,
    private val userTimeZoneName: String? = null,
    private val token: BrightHRAccountToken? = null,
    private val hasFixedWorkingTimePattern: Boolean? = null
) : Transformable<ValidatedUser> {
    override fun transform(): ValidatedUser {
        if (companyId == null) throw BrightHRMissingPropertyException("companyId")
        if (userId == null) throw BrightHRMissingPropertyException("userId")
        if (companyTimeZoneName == null) throw BrightHRMissingPropertyException("companyTimeZoneName")
        if (userTimeZoneName == null) throw BrightHRMissingPropertyException("userTimeZoneName")
        if (token == null) throw BrightHRMissingPropertyException("token")
        if (hasFixedWorkingTimePattern == null) throw BrightHRMissingPropertyException("hasFixedWorkingTimePattern")

        return ValidatedUser(companyId, userId, companyTimeZoneName, userTimeZoneName,
                token.transform(), hasFixedWorkingTimePattern)
    }
}