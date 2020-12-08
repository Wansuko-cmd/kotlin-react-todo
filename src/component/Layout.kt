package component

import react.*

val layout = functionalComponent<RProps> {
    val testData = mutableListOf(TodoData(0, "test", false), TodoData(1, "ok", false))
    val (list, setList) = useState(testData)

    header()
    inputTodo(list, setList)
    outputTodo(list, setList)
}



fun RBuilder.layout() = child(layout)