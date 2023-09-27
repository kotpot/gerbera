package org.kotpot.gerbera.process


sealed class Process {
    abstract val block: suspend () -> Unit
    abstract val next: ProcessSwitcher
}

class ProcessBuilder {


    private class ProcessImpl : Process() {
        override var block: suspend () -> Unit = {}
        override var next: ProcessSwitcher = ProcessSwitcher.NEXT
    }

    fun build(): Process = this
}