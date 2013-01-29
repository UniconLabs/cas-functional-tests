package net.unicon.cas.functionaltests.pages

import geb.*

/**
 *
 * @author Dmitriy Kopylenko
 * @author Unicon, inc
 */
class GoogleHomePage extends Page {
    static url = "https://www.google.com"
    static at = { title == "Google" }
}