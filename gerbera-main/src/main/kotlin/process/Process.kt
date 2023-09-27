package org.kotpot.gerbera.process


class ProcessRunner constructor(init: Builder.() -> Unit) {

    class Builder {
        var block: suspend () -> Unit = {}
        var next: ProcessSwitcher = ProcessSwitcher.NEXT
    }

    init {
        val builder = Builder()
        builder.init()
    }
}
