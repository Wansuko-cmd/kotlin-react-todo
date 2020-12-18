package component

import react.RBuilder
import react.RProps
import react.child
import react.dom.button
import react.functionalComponent
import react.router.dom.routeLink

interface NavigatorProps: RProps{
    var to: List<String>
}

val navigator = functionalComponent<NavigatorProps> {props ->
    props.to.map{
        routeLink(it){
            button {
                +it
            }
        }
    }
}

fun RBuilder.navigator(to: List<String> ) = child(navigator){
    attrs.to = to
}