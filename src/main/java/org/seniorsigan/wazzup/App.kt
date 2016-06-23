package org.seniorsigan.wazzup

import org.slf4j.LoggerFactory
import spark.ModelAndView
import spark.Spark
import spark.template.jade.JadeTemplateEngine

object App {
    val log = LoggerFactory.getLogger(App::class.java)
    
    @JvmStatic
    fun main(args: Array<String>) {
        val service = Service()
        val jade = JadeTemplateEngine()
        val jadeConfig = jade.configuration()

        Spark.get("/", {req, res ->
            val src = service.retrieveCode("https://web.whatsapp.com/")
            ModelAndView(mapOf(Pair("src", src)), "index")
        }, jade)
    }
}