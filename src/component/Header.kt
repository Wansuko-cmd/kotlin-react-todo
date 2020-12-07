package component

import react.RBuilder
import react.RProps
import react.child
import react.dom.h1
import react.functionalComponent


val header = functionalComponent<RProps> {
    h1{
        +"Header"
    }
}

fun RBuilder.header() = child(header)