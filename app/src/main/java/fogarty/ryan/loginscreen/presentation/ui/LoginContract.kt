package fogarty.ryan.loginscreen.presentation.ui

interface LoginContract {
    interface View : HasProgressBar {
        fun setLoginButtonEnabled(enable: Boolean)
        fun displayLoginResponse(responseCode: Int?, userTimeZoneName: String?)
    }
}