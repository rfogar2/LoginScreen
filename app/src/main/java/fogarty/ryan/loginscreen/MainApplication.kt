package fogarty.ryan.loginscreen

import android.app.Application
import fogarty.ryan.loginscreen.dagger.AppModule
import fogarty.ryan.loginscreen.dagger.DaggerNetworkComponent
import fogarty.ryan.loginscreen.dagger.NetworkComponent
import fogarty.ryan.loginscreen.dagger.NetworkModule

class MainApplication : Application() {
    lateinit var networkComponent: NetworkComponent
        private set

    override fun onCreate() {
        super.onCreate()

        networkComponent = DaggerNetworkComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule("http://brighthr-api-uat.azurewebsites.net"))
                .build()
    }
}