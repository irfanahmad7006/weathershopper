selenium-cucumber-java-maven
=================

Automation Testing Using Java, Selenium with Cucumber.

selenium-cucumber is a behavior driven development (BDD) approach to write automation test scripts to test Web Application.
It enables you to write and execute automated acceptance/unit tests.
It is cross-platform, open source and free.
Automate your test cases with minimal coding.

Framework Architecture
--------------
	Project-Name
		|
		|_src/main/java
		|	|_driverFactory
		|	|	|_DriverFactory.java
		|	|
		|	|_weatherShopPages
		|	|	|_BuyProductsPage.java
		|	|	|_CheckOutPage.java
		|	|	|_HomePage.java
		|	|_utils
		|		|_ConfigReader.java
		|		|...
		|
		|_src/test/java
		|	|_applicationHooks
		|	|	|_ApplicationHooks.java
		|	|
		|	|_stepdefs
		|	|	|_HomePageStepDefs.java
		|	|	|_BuyProductsStepDefs.java
		|	|	|...
		|_src/test/resources
            |    |_featureFiles
            |       |_config.properties


* **src/test/resources/featureFiles** - all the cucumber features files (files .feature ext) goes here.
* **src/test/java/stepdefs** - you can define step defintion under this package for your feature steps.
* **src/test/resources/config.properties** - When you run your test on browser type e.g. browser=chrome, application url etc, you have to provide information here.


Writing a test
--------------
* The cucumber features goes in the `featuresFiles` library and should have the ".feature" extension.
* You can start out by looking at `featuresFiles/E2E Chepeast weather shopping.feature`. You can extend this feature or make your own features using some of the predefined steps that comes with selenium-cucumber.

Execution from CMD
-----------------
* git clone https://github.com/irfanahmad7006/weathershopper
* cd weathershopper
* Run `mvn clean test` in cmd prompt for parallel execution.


Execution from IDE
-----------------  
* You can start execution from `featuresFiles/E2E Chepeast weather shopping.feature` directly for single feature execution.
* You can start execution from `src/test/java/runner/RunTest.java` for sequential execution.
* You can run `mvn clean install` Or `mvn clean verify` Or `mvn clean test`in cmd for parallel execution from terminal.

Set-Up prerequisites.
-----------------
* Java version - jdk 1.8.0_281,
* Maven version - apache maven 3.8.1,      
* maven-surefire-plugin - 3.0.0-M1
* IntelliJ/Eclipse Cucumber plugins

Maven Dependencies.
-----------------
* cucumber-java - 6.11.0
* cucumber-junit - 6.11.0
* junit - 4.13.2
* webdrivermanager - 5.0.3
* selenium-java - 4.0.0

