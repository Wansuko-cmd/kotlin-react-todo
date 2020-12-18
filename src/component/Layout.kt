package component

import react.*

val layout = functionalComponent<RProps> { props ->
    val list : List<String> = listOf("/", "/checked", "/unchecked")

    header()
    navigator(list)
    props.children()
}

fun RBuilder.layout() = child(layout){}