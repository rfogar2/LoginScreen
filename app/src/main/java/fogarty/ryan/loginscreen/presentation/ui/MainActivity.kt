package fogarty.ryan.loginscreen.presentation.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import fogarty.ryan.loginscreen.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        startActivity(Intent(this, LoginActivity::class.java))
    }
}
