package component.showTodo

import component.TodoData
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.button
import react.dom.input

interface InputTodoProps: RProps{
    var list: MutableList<TodoData>
    var setList: RSetState<MutableList<TodoData>>
}

val inputTodo = functionalComponent<InputTodoProps> { props ->
    val (item, setItem) = useState("")

    input {
        attrs {
            value = item
            onChangeFunction = {
                val target = it.target as HTMLInputElement
                setItem(target.value)
            }
        }
    }

    button {
        attrs.onClickFunction = {
            if (item != "") {
                val lists = mutableListOf<TodoData>()
                props.list.map {
                    lists.add(it)
                }
                lists.add(TodoData(lists.size, item, false))
                props.setList(lists)
                setItem("")
            }
        }
        +"Submit"
    }
}

fun RBuilder.inputTodo(list: MutableList<TodoData>, setList: RSetState<MutableList<TodoData>>) = child(inputTodo){
    attrs.list = list
    attrs.setList = setList
}
