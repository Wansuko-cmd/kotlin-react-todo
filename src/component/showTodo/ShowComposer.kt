package component.showTodo

import component.TodoData
import react.*

interface ShowComposerProps: RProps{
    var to: String
}

val showComposer = functionalComponent<ShowComposerProps> {props ->
    val testData = mutableListOf(TodoData(0, "test", false), TodoData(1, "ok", false))
    val (list, setList) = useState(testData)

    inputTodo(list, setList)
    outputTodo(props.to, list, setList)
}

fun RBuilder.showComposer(to: String) = child(showComposer){
    attrs.to = to
}
