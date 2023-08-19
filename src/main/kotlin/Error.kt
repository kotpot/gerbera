package com.kotpot

object ErrorMessage {

    private const val SHOW_NAME = "${Config.PROJECT_NAME}@${Config.VERSION}"
    private const val COMMAND = Config.MAIN_COMMAND

    val EMPTY_ARGUMENTS = """
        Use `$COMMAND help` to learn how to use $SHOW_NAME,
        or read the instructions in ${Config.DOCUMENT_SITE}.
    """.trimIndent()
}


