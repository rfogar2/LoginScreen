package fogarty.ryan.loginscreen.dagger.components

import dagger.Component
import fogarty.ryan.loginscreen.dagger.modules.LoginModule
import fogarty.ryan.loginscreen.dagger.scopes.UseCaseScope
import fogarty.ryan.loginscreen.presentation.ui.LoginActivity

@UseCaseScope
@Component(modules = [LoginModule::class], dependencies = [NetworkComponent::class])
interface LoginComponent {
    fun inject(activity: LoginActivity)
}