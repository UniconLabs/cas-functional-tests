package net.unicon.cas.functionaltests.pages

import geb.Page

/**
 *
 * @author Dmitriy Kopylenko
 * @author Unicon, inc
 */
class CasLoginPage extends Page {

    static url = 'login'

    static at = {
        title.contains("Central Authentication Service")
        loginButton.value() == 'LOGIN'
    }

    static content = {
        usernameTextBox { $("input[name=username]") }
        passwordTextBox { $("input[name=password]") }
        loginButton { $("input[name=submit]") }
    }
}
