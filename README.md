# jsonplaceholder


## Automation test regression suite for jsonplaceholder rest api

### The below is test is implemented with steps

* validating the email format from each comment of all posts by user "Kamren"
	* Search for user "Kamren" and get user id
	* Search for posts made by user "Kamren" and get list of all postids
	* Search for comments of each posts and get commentids of all comments
	* All the commentids data is now passed as parameter to test
	* get email of comment in test
	* validate email format
* verifyEmailTest(com.typicode.jsonplaceholder.tests package) is the test to validate email format. This test has data provider which prepares all required test data with comment ids
* Since same test runs for different comment ids, the test names are modified by implementing getTestName() method for ITest
* Pojo design pattern - Transfer Object pattern implemented to represent the request and response data and also used for serialization and deserialization as well.


### Tools and Technologies used

* Java (1.8 or higher)
* TestNG
* RestAssured
* Maven
* Extent Report

### Configuration/setup to be done to run the project

* The below details are configured in config.properies file(available in petstore\src\main\java\com\zooplus\config\config.properties)
	* baseURI for pet store rest api

* TestBase class (com.typicode.jsonplaceholder.base) is base class for all tests and it provides configurations like baseURI and base directory of project to tests
* All test classes (com.typicode.jsonplaceholder.tests package) extends TestBase class to inherit base configuration data.


### To Run Tests
* testng.xml file is configured with tests and extent reports
* run the tests by executing the testng.xml file as testng suite
* after tests run, open report under test-output/TestReport.html to see interactive HTML report on test execution status.
* for testng report, open test-output/index.html

# Note: The test name along with parameter data is not reflecting in extent report(same test name repeated) but it can seen in testng (Test name with comment id) report and execution logs, this is an improvement point


