package component.showTodo

import component.TodoData
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import react.*
import react.dom.div
import react.dom.input

interface OutputProps : RProps{
    var kind: String
    var list: MutableList<TodoData>
    var setList: RSetState<MutableList<TodoData>>
}

val OutputTodo = functionalComponent<OutputProps> { props ->
    var list: List<TodoData> = props.list
    when(props.kind){
        "true" -> {
            list = list.filter { it.check }
            console.log("checked")
        }
        "false" -> {
            list = list.filter { !it.check }
            console.log("unchecked")
        }
    }

    list.map {
        val key = it.id
        div{
            input{
                attrs{
                    type = InputType.checkBox
                    checked = it.check
                    onChangeFunction = {
                        val lists = mutableListOf<TodoData>()
                        props.list.map {inner ->
                            if(key == inner.id) inner.check = !inner.check
                            lists.add(inner)
                        }
                        props.setList(lists)
                    }
                }
            }
            +it.item
        }
    }
}

fun RBuilder.outputTodo(kind: String, list: MutableList<TodoData>, setList: RSetState<MutableList<TodoData>>) = child(OutputTodo) {
    attrs.kind = kind
    attrs.list = list
    attrs.setList = setList
}