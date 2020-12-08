package component

import kotlinx.css.input
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import react.*
import react.dom.div
import react.dom.input
import react.dom.p

interface OutputProps : RProps{
    var list: MutableList<TodoData>
    var setList: RSetState<MutableList<TodoData>>
}

val OutputTodo = functionalComponent<OutputProps> {props ->
    props.list.map {
        val key = it.id
        div{
            input{
                attrs{
                    type = InputType.checkBox
                    onChangeFunction = {
                        val lists = mutableListOf<TodoData>()
                        props.list.map {inner ->
                            if(key == inner.id) inner.check = !inner.check
                            lists.add(inner)
                        }
                        props.setList(lists)
                        console.log(lists)
                    }
                }
            }
            +it.item
        }
    }
}

fun RBuilder.outputTodo(list: MutableList<TodoData>, setList: RSetState<MutableList<TodoData>>) = child(OutputTodo) {
    attrs.list = list
    attrs.setList = setList
}