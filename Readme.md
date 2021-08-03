# Booking Api Test Automation Framework

Automation framework to test all the api endpoints and capable enough to scale and maintain without easily
## Getting Started

To get started clone project from github.

Below are the api used to write this framework which will help you drive your test.
* TestNg
* RestAssured

Prerequisites

* JDK 1.8 or hire version should be installed.
* Gradle should be installed.


The library which plays a major role in building this framework is Rest Assured.  REST Assured is a Java library that provides a domain-specific language (DSL) for writing powerful, maintainable tests for RESTful APIs.

Folder Structure:
```

└── src
    ├── main
    │   ├── java
    │   └── resources
    └── test
        ├── java
        │   └── com
        │       └── api
        │           ├── entities
        │           │   └── booking
        │           │       ├── request
        │           │       └── response
        │           ├── requestBuilders
        │           ├── testData
        │           ├── tests
        │           └── util
        └── resources

```

## Configuration

* Environment config files (*.properties) to target your service.

These two files should be placed in below directories
* [Environment config](https://github.com/vinaygupta2050/ApiTestAutomationFramework/tree/master/src/main/resources)

### Target Environments
The framework is designed so that multiple environments along with their required vairables can be supported and multiple services for each environment can be defined with in folder [Environment config](https://github.com/vinaygupta2050/ApiTestAutomationFramework/tree/master/src/main/resources)
```
bookingUrl=https://restful-booker.herokuapp.com/booking
userName=admin
password=password123
```
### Target End Points
List end points can be written in class [ApiEndPoints](https://github.com/vinaygupta2050/ApiTestAutomationFramework/blob/master/src/main/java/com/api/apiFactory/ApiEndPoints.java)

### Payloads
The framework is written in such a way that user needs to create a POJO class for the respective JSON reqruest or payload with which we wanted to hit the end points. The POJO class should be written in folder [entities](https://github.com/vinaygupta2050/ApiTestAutomationFramework/tree/master/src/main/java/com/api/pojo).

## Writing Test

Once you have finished your configuration you can begin writing your test by extending [BookingBaseTest](https://github.com/vinaygupta2050/ApiTestAutomationFramework/blob/master/src/test/java/com/api/test/BaseTest.java) to your respective test. Below ist sample code.
```
    @Test(groups = Categories.BOOKING,dataProviderClass = BookingTestData.class, dataProvider = "newUserData")
    public void shouldCreateBookingId(String firstName,String lastname,int totalprice,boolean depositpaid,String checkin, String checkOut,String additionalneeds) throws Exception {
        CreateBookingRequest request = new BookingRequestBuilder(firstName,lastname,totalprice,depositpaid,checkin,checkOut,additionalneeds).build();
        CreateBookingResponse response = createBookingId(request);
        response.assertResponse();
    }

```

## Running your Test
When you are ready to run your tests from the command line, below are a few examples of run commands (standard maven command line syntax):

* We can run the test agains the specific environment which will pick all the urls from their respective properties file. User below command to run your test
```
./gradlew BookingTest -Denv=dev
```
## Test Results

Once all the test are executed results can be generated in [/ApiTestWithGradle/build/reports/tests/BookingTest/index.html]

## Author

* **Vinaykumar Gupta** - [LinkedIn](https://in.linkedin.com/in/vinaygupta2050)