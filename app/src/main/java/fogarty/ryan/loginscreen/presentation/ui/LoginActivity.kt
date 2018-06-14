package fogarty.ryan.loginscreen.presentation.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import fogarty.ryan.loginscreen.MainApplication
import fogarty.ryan.loginscreen.R
import fogarty.ryan.loginscreen.dagger.components.DaggerLoginComponent
import fogarty.ryan.loginscreen.dagger.modules.LoginModule
import fogarty.ryan.loginscreen.presentation.presenters.LoginPresenter
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginContract.View {
    @Inject
    lateinit var presenter: LoginPresenter

    private val usernameInput by lazy { findViewById<EditText>(R.id.username) }
    private val passwordInput by lazy { findViewById<EditText>(R.id.password) }
    private val loginButton by lazy { findViewById<Button>(R.id.login) }
    private val indeterminateBar by lazy { findViewById<ProgressBar>(R.id.indeterminateBar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        DaggerLoginComponent.builder()
                .loginModule(LoginModule())
                .networkComponent((application as MainApplication).networkComponent)
                .build()
                .inject(this)

        setupViews()
    }

    override fun onStart() {
        super.onStart()

        presenter.onViewAttached(this)
    }

    override fun onStop() {
        presenter.onViewDetached()

        super.onStop()
    }

    override fun displayLoginResponse(responseCode: Int?, userTimeZoneName: String?) {
        val response = when (responseCode) {
            200 -> getString(R.string.login_success, userTimeZoneName ?: "")
            403 -> getString(R.string.login_error_403)
            else -> getString(R.string.login_error_other)
        }

        Toast.makeText(this, response, Toast.LENGTH_LONG).show()
    }

    override fun setLoginButtonEnabled(enable: Boolean) {
        loginButton.isEnabled = enable
    }

    override fun showProgressBar(show: Boolean) {
        indeterminateBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun setupViews() {
        setLoginButtonEnabled(false)

        usernameInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.username = charSequence?.toString() ?: ""
            }

            override fun afterTextChanged(p0: Editable?) = Unit
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
        })

        passwordInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.password = charSequence?.toString() ?: ""
            }

            override fun afterTextChanged(p0: Editable?) = Unit
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
        })

        loginButton.setOnClickListener({ presenter.login() })

        indeterminateBar.isIndeterminate = true
    }
}
