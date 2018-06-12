package fogarty.ryan.loginscreen.presentation.presenters

import fogarty.ryan.loginscreen.presentation.ui.LoginContract
import kotlin.properties.Delegates

class LoginPresenter : BasePresenter<LoginContract.View>() {
    var username: String by Delegates.observable("") { _, _, newValue ->
        setLoginButtonEnabled(newValue, password)
    }
    var password: String by Delegates.observable("") { _, _, newValue ->
        setLoginButtonEnabled(username, newValue)
    }

    private fun setLoginButtonEnabled(username: String, password: String) {
        view?.setLoginButtonEnabled(username.trim().isNotEmpty() && password.trim().isNotEmpty())
    }

    fun login() {
        // TODO: postValidateUser network call
    }
}