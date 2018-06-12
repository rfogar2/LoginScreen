package fogarty.ryan.loginscreen.network.model.account

import fogarty.ryan.loginscreen.domain.AccountToken
import fogarty.ryan.loginscreen.domain.Transformable
import fogarty.ryan.loginscreen.network.validation.BrightHRMissingPropertyException

data class BrightHRAccountToken(
    private val token: String? = null,
    private val userId: String? = null
) : Transformable<AccountToken> {
    override fun transform(): AccountToken {
        if (token == null) throw BrightHRMissingPropertyException("token")

        return AccountToken(token, userId)
    }
}