package fogarty.ryan.loginscreen.network.model.account

import fogarty.ryan.loginscreen.network.validation.BrightHRMissingPropertyException
import org.junit.Test

class BrightHRAccountTokenTest {
    private val brightHRAccountToken = BrightHRAccountToken("token")

    @Test(expected = BrightHRMissingPropertyException::class)
    fun missingToken() {
        brightHRAccountToken.copy(token = null).transform()
    }
}