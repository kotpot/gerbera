package org.kotpot.gerbera.html.templates

import java.io.File

/**
 * Used to convert HTML templates.
 */
interface HtmlTemplateParser {


    /**
     * Provides model for the HTML template file and convert it to the target HTML string.
     *
     * @param htmlFile html file that is conversion target
     * @param model html file context model
     *
     * @return final html string
     */
    fun parse(htmlFile: File, model: Map<String, Any>): String
}