import component.layout
import component.showTodo.showComposer
import react.RBuilder
import react.child
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

fun RBuilder.routing() = browserRouter {
    child(layout){
        switch {
            route("/", exact = true){showComposer("all")}
            route("/checked", exact = true){showComposer("true")}
            route("/unchecked", exact = true){showComposer("false")}
        }
    }
}