package fogarty.ryan.loginscreen.presentation.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import fogarty.ryan.loginscreen.MainApplication
import fogarty.ryan.loginscreen.R
import retrofit2.Retrofit
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        (application as MainApplication).networkComponent.inject(this)
    }
}
