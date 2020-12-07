package component

import react.*

val layout = functionalComponent<RProps> {
    val testData = mutableListOf(TodoData("test", false), TodoData("ok", true))
    val (list, setList) = useState(testData)

    header()
    inputTodo(list, setList)
    outputTodo(list)
}



fun RBuilder.layout() = child(layout)