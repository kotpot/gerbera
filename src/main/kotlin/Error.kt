package com.kotpot

object ErrorMessage {

    private const val SHOW_NAME = "${Defined.PROJECT_NAME}@${Defined.VERSION}"
    private const val COMMAND = Defined.MAIN_COMMAND

    val EMPTY_ARGUMENTS = """
        Use `$COMMAND help` to learn how to use $SHOW_NAME,
        or read the instructions in ${Defined.DOCUMENT_SITE}.
    """.trimIndent()
}


