package component

import react.RBuilder
import react.RProps
import react.child
import react.dom.p
import react.functionalComponent

interface OutputProps : RProps{
    var list: MutableList<TodoData>
}

val OutputTodo = functionalComponent<OutputProps> {props ->
    props.list.map {
        p{
            +it.item
        }
    }
}

fun RBuilder.outputTodo(list: MutableList<TodoData>) = child(OutputTodo) {
    attrs.list = list
    console.log(list)
}