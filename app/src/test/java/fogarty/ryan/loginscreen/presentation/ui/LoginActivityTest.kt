package fogarty.ryan.loginscreen.presentation.ui

import android.widget.Button
import android.widget.EditText
import fogarty.ryan.loginscreen.BuildConfig
import fogarty.ryan.loginscreen.R
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class LoginActivityTest {
    @Test
    fun defaultUsernameAndPassword_shouldDisableLoginButton() {
        val loginActivity = Robolectric.setupActivity(LoginActivity::class.java)

        val loginButton = loginActivity.findViewById<Button>(R.id.login)

        assertFalse(loginButton.isEnabled)
    }

    @Test
    fun validUsernameInvalidPassword_shouldDisableLoginButton() {
        val loginActivity = Robolectric.setupActivity(LoginActivity::class.java)

        loginActivity.findViewById<EditText>(R.id.username).setText("a")
        val loginButton = loginActivity.findViewById<Button>(R.id.login)

        assertFalse(loginButton.isEnabled)
    }

    @Test
    fun invalidUsernameValidPassword_shouldDisableLoginButton() {
        val loginActivity = Robolectric.setupActivity(LoginActivity::class.java)

        loginActivity.findViewById<EditText>(R.id.password).setText("a")
        val loginButton = loginActivity.findViewById<Button>(R.id.login)

        assertFalse(loginButton.isEnabled)
    }

    @Test
    fun validUsernameValidPassword_shouldEnableLoginButton() {
        val loginActivity = Robolectric.setupActivity(LoginActivity::class.java)

        loginActivity.findViewById<EditText>(R.id.username).setText("a")
        loginActivity.findViewById<EditText>(R.id.password).setText("a")
        val loginButton = loginActivity.findViewById<Button>(R.id.login)

        assertTrue(loginButton.isEnabled)
    }
}