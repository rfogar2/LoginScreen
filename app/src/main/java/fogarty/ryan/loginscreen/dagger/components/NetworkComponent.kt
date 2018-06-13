package fogarty.ryan.loginscreen.dagger.components

import android.app.Activity
import dagger.Component
import fogarty.ryan.loginscreen.dagger.modules.AppModule
import fogarty.ryan.loginscreen.dagger.modules.NetworkModule
import fogarty.ryan.loginscreen.network.services.BrightHRAccountService
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface NetworkComponent {
    fun inject(activity: Activity)

    fun exposeAccountService(): BrightHRAccountService
}