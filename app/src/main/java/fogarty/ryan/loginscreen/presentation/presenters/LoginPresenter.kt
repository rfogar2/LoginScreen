package fogarty.ryan.loginscreen.presentation.presenters

import fogarty.ryan.loginscreen.network.model.account.BrightHRPostValidateUserResponse
import fogarty.ryan.loginscreen.network.services.BrightHRAccountService
import fogarty.ryan.loginscreen.presentation.ui.LoginContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.Delegates

class LoginPresenter : BasePresenter<LoginContract.View>() {
    lateinit var accountService: BrightHRAccountService

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
        view?.showProgressBar(true)
        accountService.postValidateUser(username, password).enqueue(object : Callback<BrightHRPostValidateUserResponse> {
            override fun onResponse(call: Call<BrightHRPostValidateUserResponse>?, response: Response<BrightHRPostValidateUserResponse>?) {
                view?.showProgressBar(false)
                view?.displayLoginResponse(response?.code(), response?.body()?.userTimeZoneName)
            }

            override fun onFailure(call: Call<BrightHRPostValidateUserResponse>?, t: Throwable?) {
                view?.showProgressBar(false)
            }
        })
    }
}