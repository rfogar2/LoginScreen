package fogarty.ryan.loginscreen.presentation.presenters

interface Presenter<V> {
    var view: V?

    fun onViewAttached(view: V) {
        this.view = view
    }

    fun onViewDetached() {
        view = null
    }
}

abstract class BasePresenter<V> : Presenter<V> {
    override var view: V? = null
}