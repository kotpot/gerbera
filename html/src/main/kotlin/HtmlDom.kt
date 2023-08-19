package com.kotpot.html

import java.lang.StringBuilder

abstract class HtmlDom(val name: String) {

    var id: String? = null
    var classes: String? = null

    internal abstract fun customProperties(): Map<String, String>

    internal abstract fun content(): String
}

sealed class HtmlDomParent(name: String) : HtmlDom(name) {

    private val elements = mutableListOf<HtmlDom>()

    internal open fun HtmlDom.element(dom: HtmlDom): HtmlDom {
        elements.add(dom)
        return dom
    }

    override fun content(): String {
        val builder = StringBuilder()
        for (element in elements) {
            builder.append(element.content())
            builder.append("\n")
        }
        return builder.toString()
    }
}

class Div : HtmlDomParent("dev") {

    override fun customProperties(): Map<String, String> {
        TODO("Not yet implemented")
    }
}

class P : HtmlDomParent("p") {

    var text: String = ""

    override fun customProperties(): Map<String, String> {
        TODO("Not yet implemented")
    }

}


fun HtmlDomParent.div(block: Div.() -> Unit) = element(Div())
fun HtmlDomParent.p(block: P.() -> Unit) = element(P())


fun HtmlDomParent.text() {
    // exp

    div {
        id = "div_id"

        div {
            id = "div_id"

            for (i in 1..10) {

                p {
                    id = "text_$i"
                    text = "Num: $i"
                }
            }
        }
    }
}

