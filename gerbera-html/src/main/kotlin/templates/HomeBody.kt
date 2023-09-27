package org.kotpot.gerbera.html.templates

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import kotlinx.html.title

fun HomeBody() = createHTML().body {
    title
}