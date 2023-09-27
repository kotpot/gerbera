package org.kotpot.gerbera.process

import java.util.LinkedList

sealed class ProcessManager {

    protected abstract val processes: List<Process>

    companion object {

        fun build(build: ProcessManagerBuilder.() -> Unit): ProcessManager {

            val builder = ProcessManagerBuilder()

        }

    }

}

class ProcessManagerBuilder: ProcessManager() {
    override val processes = ArrayList<Process>()

    fun process(init: ProcessBuilder.() -> Unit) {
        val builder = ProcessBuilder()
        builder.init()
        val process = builder.build()
        processes.add(process)
    }

    fun build(): ProcessManager = this
}