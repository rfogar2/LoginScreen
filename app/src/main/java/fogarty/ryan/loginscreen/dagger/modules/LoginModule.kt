package fogarty.ryan.loginscreen.dagger.modules

import dagger.Module
import dagger.Provides
import fogarty.ryan.loginscreen.dagger.scopes.UseCaseScope
import fogarty.ryan.loginscreen.presentation.presenters.LoginPresenter

@Module
class LoginModule {
    @Provides
    @UseCaseScope
    internal fun provideLoginPresenter(): LoginPresenter {
        return LoginPresenter()
    }
}