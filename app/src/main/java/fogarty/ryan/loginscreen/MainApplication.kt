package fogarty.ryan.loginscreen

import android.app.Application
import fogarty.ryan.loginscreen.dagger.modules.AppModule
import fogarty.ryan.loginscreen.dagger.components.DaggerNetworkComponent
import fogarty.ryan.loginscreen.dagger.components.NetworkComponent
import fogarty.ryan.loginscreen.dagger.modules.NetworkModule

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