package org.kotpot.gerbera.html.templates.impl

import org.kotpot.gerbera.html.templates.HtmlTemplateParser
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import org.thymeleaf.templateresolver.FileTemplateResolver
import java.io.File


class ThymeleafParser: HtmlTemplateParser {

    override fun parse(htmlFile: File, model: Map<String, Any>): String {

        val engine = TemplateEngine()
        val resolver = FileTemplateResolver()

        resolver.prefix = htmlFile.parent + "/"
        resolver.suffix = ".html"
        resolver.characterEncoding = "UTF-8"
        resolver.setTemplateMode(TemplateMode.HTML) // HTML5 option was deprecated in 3.0.0

        val context = Context().apply {
            setVariables(model)
        }

        engine.setTemplateResolver(resolver)
        return engine.process(htmlFile.name, context)
    }

}