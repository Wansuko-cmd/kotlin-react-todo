package component

import component.showTodo.inputTodo
import component.showTodo.outputTodo
import component.showTodo.showComposer
import react.*

interface LayoutProps: RProps{
    var to: String
}

val layout = functionalComponent<LayoutProps> { props ->
    val testData = mutableListOf(TodoData(0, "test", false), TodoData(1, "ok", false))
    val (list, setList) = useState(testData)

    header()
    props.children()
    inputTodo(list, setList)
    outputTodo(list, setList)

}



fun RBuilder.layout(to: String) = child(layout){
    attrs.to = to
}