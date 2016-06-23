package org.seniorsigan.wazzup

import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.remote.RemoteWebElement
import org.slf4j.LoggerFactory
import java.net.URL

class Service {
    val log = LoggerFactory.getLogger(Service::class.java)
    val driverAddress = URL("http://127.0.0.1:4444/wd/hub")

    fun retrieveCode(url: String): String? {
        log.info("Open connection to selenium")
        val capabilities = DesiredCapabilities.chrome()
        val wd = RemoteWebDriver(driverAddress, capabilities)
        log.info("Open $url")
        wd.get(url)
        var data: String? = null
        var tries = 0
        var success = false
        log.info("Search code")
        while (tries < 10 && success != true) {
            tries++
            try {
                Thread.sleep(500)
                data = (wd.findElementByClassName("qrcode") as RemoteWebElement?)?.findElementByTagName("img")?.getAttribute("src")
                success = true
            } catch(e: Exception) {
                log.error(e.message)
            }
        }
        log.info("Finished with $tries tries")
        return data
    }
}