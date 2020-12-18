package component.showTodo

import kotlinx.html.RP
import react.RBuilder
import react.RProps
import react.child
import react.dom.h1
import react.functionalComponent

interface ShowComposerProps: RProps{
    var text: String
}

val showComposer = functionalComponent<ShowComposerProps> {props ->
    h1{
        +props.text
    }
}

fun RBuilder.showComposer(text: String) = child(showComposer){
    attrs.text = text
}
