package index

import app.*
import react.dom.*
import kotlinx.browser.*

fun main(args: Array<String>) {
    render(document.getElementById("root")) {
        app()
    }
}
