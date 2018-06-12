package fogarty.ryan.loginscreen.presentation.ui

interface LoginContract {
    interface View {
        fun setLoginButtonEnabled(enable: Boolean)
        fun displayMessage(message: String)
    }
}