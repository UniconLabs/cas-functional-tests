package net.unicon.cas.functionaltests.specs

import geb.spock.GebSpec
import net.unicon.cas.functionaltests.pages.CasGenericSuccessfulLoginPage
import net.unicon.cas.functionaltests.pages.CasLoginPage
import net.unicon.cas.functionaltests.pages.GoogleHomePage

/**
 * Collection of automated functional tests for CAS server using Geb/Spock frameworks
 *
 * @author Dmitriy Kopylenko
 * @author Unicon, inc
 */
class CasSpec extends GebSpec {

    def "correct CAS login page"() {
        when:
        to CasLoginPage

        then:
        at CasLoginPage

        when: 'submitting empty login form'
        loginButton.click()

        then:
        at CasLoginPage
    }

    def "successful login with no service parameter"() {
        when:
        to CasLoginPage

        then:
        at CasLoginPage

        when: 'submitting login form with username and password, but no service parameter'
        usernameTextBox = 'test'
        passwordTextBox = 'test'
        loginButton.click()

        then:
        at CasGenericSuccessfulLoginPage
    }

    def "successful login to an authorized service with subsequent redirect and also a subsequent SSO check"() {
        given:
        CasLoginPage.url = "https://dk.example.org:8143/cas/login?service=https://www.google.com"

        when:
        to CasLoginPage

        then:
        at CasLoginPage

        when: 'submitting login form with username and password, and a service parameter passed via URL'
        usernameTextBox = 'test'
        passwordTextBox = 'test'
        loginButton.click()

        then: 'CAS successfully authenticates the presented credentials and redirects to a target service URL with the service ticket URL parameter'
        at GoogleHomePage
        withServiceTicket(driver.currentUrl, isValidServiceTicket)

        when: 'there is an existing SSO session, there is an immediate redirect to a service URL without the need to authenticate again'
        to CasLoginPage

        then:
        at GoogleHomePage
        withServiceTicket(driver.currentUrl, isValidServiceTicket)
    }

    //Closure to see if the ticket is a valid ST
    private isValidServiceTicket = { it?.contains('ST-') }

    //Method to extract the ST from URL and pass it to a provided Closure for further processing
    private withServiceTicket(url, closure) {
        def serviceTicket = url.substring([url.indexOf('?ticket')]).tokenize('=')[1]
        closure(serviceTicket)
    }
}
