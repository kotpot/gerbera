package com.kotpot

fun main(vararg args: String) {
    execute(args)
}


private fun execute(args: Array<out String>) {

    require(args.isNotEmpty()) {
        ErrorMessage.EMPTY_ARGUMENTS
    }

    val combination = CommandCombination.get(args[0])

    combination.execute(args)

}
