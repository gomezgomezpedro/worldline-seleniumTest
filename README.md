# TEST EXECUTION INSTRUCTIONS

1. Download locally the appropiated chromedriver.exe file for your Google Chrome browser

2. Clone the project in the selected IDE (recommended IntelliJ IDEA Community Edition)

3. If using IntelliJ IDEA, install Gherkin and Cucumber for Java plugins. This is only necessary for IntelliJ+JUnit execution

4. Ensure Maven is downloaded and added to environment variables, as it is necessary to execute the test cases from the terminal

5. Inside the project, open the following file:
   src/test/resources/config.properties
   And in the property "webdriverPath", specify the path of the chromedriver downloaded in step 1

6. Open the terminal and introduce the following command:
   mvn install
   This will install all Maven dependencies

7. To select test cases to execute, open the following file:
   src/test/java/RunCukeTest.java
   In the CucumberOptions section, in features, specify which feature file will be executed:
   Example:
   features = "src/test/resources/Features/GoogleExample.feature"
   Otherwise, leaving the Features directory will execute all feature files:
   features = "src/test/resources/Features"

8. Finally, there are two ways of executing the test cases:
   With IntelliJ+JUNit:
   Run RunCukeTest.java (the same file modified in step 8)
   With Maven:
   Open the terminal and introduce the following command:
   mvn clean test
   Said command will clean the target directory and execute all features indicated in RunCukeTest.java, being the only test class in the project
