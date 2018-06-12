package fogarty.ryan.loginscreen.network.model.account

import fogarty.ryan.loginscreen.network.validation.BrightHRMissingPropertyException
import org.junit.Test

class BrightHRPostValidateUserResponseTest {
    private val brightHRAccountToken = BrightHRAccountToken("token")
    private val brightHRPostValidateUserResponse = BrightHRPostValidateUserResponse(22846, 25050,
            "Europe/London", "Europe/London", brightHRAccountToken,
            true)

    @Test(expected = BrightHRMissingPropertyException::class)
    fun missingCompanyId() {
        brightHRPostValidateUserResponse.copy(companyId = null).transform()
    }

    @Test(expected = BrightHRMissingPropertyException::class)
    fun missingUserId() {
        brightHRPostValidateUserResponse.copy(userId = null).transform()
    }

    @Test(expected = BrightHRMissingPropertyException::class)
    fun missingCompanyTimeZoneName() {
        brightHRPostValidateUserResponse.copy(companyTimeZoneName = null).transform()
    }

    @Test(expected = BrightHRMissingPropertyException::class)
    fun missingUserTimeZoneName() {
        brightHRPostValidateUserResponse.copy(userTimeZoneName = null).transform()
    }

    @Test(expected = BrightHRMissingPropertyException::class)
    fun missingToken() {
        brightHRPostValidateUserResponse.copy(token = null).transform()
    }

    @Test(expected = BrightHRMissingPropertyException::class)
    fun missingHasFixedWorkingTimePattern() {
        brightHRPostValidateUserResponse.copy(hasFixedWorkingTimePattern = null).transform()
    }
}