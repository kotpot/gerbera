package org.kotpot.gerbera

import org.kotpot.gerbera.common.def.ErrorMessage
import org.kotpot.gerbera.configuration.Configuration

fun main(vararg args: String) {
    prepareExecutor(args)
}


private fun prepareExecutor(args: Array<out String>) {

    require(args.isNotEmpty()) {
        ErrorMessage.EMPTY_ARGUMENTS
    }

    // parse command args
    val combination = CommandCombination[args[0]]
    val runner = combination.prepareExecutor(args)

    // init configuration
    val curRoot = System.getProperty("user.dir")
    Configuration.init(curRoot)

    runner.invoke()

    
}
