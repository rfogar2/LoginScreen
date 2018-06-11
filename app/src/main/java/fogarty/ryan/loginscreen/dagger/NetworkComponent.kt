package fogarty.ryan.loginscreen.dagger

import dagger.Component
import fogarty.ryan.loginscreen.presentation.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface NetworkComponent {
    fun inject(activity: MainActivity)
}