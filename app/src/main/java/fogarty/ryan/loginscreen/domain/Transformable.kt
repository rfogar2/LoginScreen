package fogarty.ryan.loginscreen.domain

interface Transformable<out EntityType> {
    fun transform(): EntityType
}