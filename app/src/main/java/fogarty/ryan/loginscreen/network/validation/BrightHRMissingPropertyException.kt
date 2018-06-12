package fogarty.ryan.loginscreen.network.validation

class BrightHRMissingPropertyException : Exception {
    constructor(attribute: String) : super("Missing property $attribute")
}