package app

import react.*
import react.dom.*

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
    }
}

fun RBuilder.app() = child(App::class) {}
