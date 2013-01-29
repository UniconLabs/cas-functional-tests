/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/
import org.openqa.selenium.firefox.FirefoxDriver

environments {

	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { new FirefoxDriver() }
	}
}

//Change this property appropriate to your environment before running the tests
baseUrl = 'https://dk.example.org:8143/cas/'