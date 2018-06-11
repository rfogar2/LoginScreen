package fogarty.ryan.loginscreen.dagger

import android.app.Activity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface NetworkComponent {
    fun inject(activity: Activity)
}