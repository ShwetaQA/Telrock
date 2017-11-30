# Telrock


The Telrock repository consists of :

1. The Automation test suite is present under 'item-search' folder. (The Automation framework is created using Webdriver-Cucumber-Java using Junit framework)

2. The API test is present under 'Telrock_API_Test.postman_collection' file.

3. The Other two - 'Telrock_TestCases' and 'Telrock Bug Report' files are the part of manual Testing.


Note: The excel testcases are used to create cucumber feature scenario.



Also, this project runs on Mac with Firefox as case-based multiple drivers code is not yet added

Pre-requisites:
Mac OS
Firefox browser should be installed

In order to make it run on windows - 1. Install gecko driver .exe and place it in BrowserDrivers folder.
                                     2. In the Testscript file 'ItemSearch_Test' change system property as 
                                     System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "//BrowserDrivers//geckodriver.exe");
