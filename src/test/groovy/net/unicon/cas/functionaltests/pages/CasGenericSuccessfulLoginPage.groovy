package net.unicon.cas.functionaltests.pages

import geb.Page

/**
 * 
 * @author Dmitriy Kopylenko
 * @author Unicon, inc
 */
class CasGenericSuccessfulLoginPage extends Page {

    static at = { successfulLoginHeader.text() == 'Log In Successful' }

    static content = {
        successfulLoginHeader { $('h2') }
    }
}
