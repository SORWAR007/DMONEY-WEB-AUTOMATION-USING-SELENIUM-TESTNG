## Dmoney-Web-Automation-using-selenium
- Selenium is a popular open-source tool used for automating web browsers, while TestNG is a testing framework that provides features like annotations, test organization, and parallel execution.
## TECHNOLOGY WE USED:
- SELENIUM
- TESTNG
- GRADLE
- ALLURE
- DEPENDENCIES WE USED:
-   testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.11.0")
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation("org.seleniumhq.selenium:selenium-java:4.31.0")
    // https://mvnrepository.com/artifact/com.github.javafaker/javafaker
    implementation("com.github.javafaker:javafaker:1.0.2")
    // https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
    implementation("com.googlecode.json-simple:json-simple:1.1.1")
    // https://mvnrepository.com/artifact/org.apache.commons/commons-csv
    implementation("org.apache.commons:commons-csv:1.14.0")
    // https://mvnrepository.com/artifact/io.qameta.allure/allure-testng
    implementation("io.qameta.allure:allure-testng:2.29.1")
  #  TEST CASES WE APPILED ON THE PROJECT:
- Register a user with all fields.
- Register a user with only mandatory fields.
- Try to register without any mandatory fields.
-Assert all cases. Save the user data into a JSON array.
- Log in as admin (pass admin credentials from the terminal) and check if the last registered user is displayed on the admin dashboard. Print the first name, email, and phone number of the last registered user, and assert it against the saved JSON data for the user.

- Log in with the last registered user and update their profile image.

- Add a cost/expenditure from a CSV file. Create a CSV file with 5 rows, each containing different item names, amounts, quantity, purchase dates, months, and remarks. This test will loop 5 times, as there are 5 data sets in the CSV.

- Print the total cost and assert it against your expected total sum of the amounts.

- Search for an item by name from the list and assert that the total cost matches the item's price.

- Create 2 test suites: one for regression and one for smoke testing. If the smoke suite is run, only test cases 5, 6, and 7 should be executed.

- Generate an Allure report for the regression suite.

- Ensuring that the proper Page Object Model (POM) pattern is followed.
- Creating regression and smoke suite

  # output

  ![Screenshot (2)](https://github.com/user-attachments/assets/c7237e5f-4c58-42c2-bfab-06ec857e1c54)

  ![Screenshot (3)](https://github.com/user-attachments/assets/1b44bbef-05ff-4a39-903e-b42526463817)

