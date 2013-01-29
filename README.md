cas-functional-tests
===================

A collection of automated in-browser functional tests for CAS server using Geb and Spock frameworks. Currently uses Firefox driver. May add additional browser drivers in the future. This is work in progress...

## Pre-requisites

* JDK 1.6+

* CAS server deployed to a local Servlet container, up and running

* Firefox browser installed

## To configure

Change `baseUrl` property appropriate to your environment in `src/resources/GebConfig.groovy`

## To run from a command line

`./gradlew test` if you don't have Gradle already installed, or `gradle test` otherwise