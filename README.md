# Adverts.ie Free Stuff Monitor

This is a Selenium WebDriver automation project built with Java and Maven.  
It monitors the **Free Stuff → Music Instruments & Equipment** category on [Adverts.ie](https://www.adverts.ie/), detects newly posted ads, and automatically requests available items.

## Technologies Used

- Java
- Maven
- Selenium WebDriver
- JUnit 5
- Page Object Model (POM) Design Pattern

## POM based structure

- `BaseTest.java` → Initializes and manages WebDriver setup and teardown.
- `pages/` → Contains Page Object Model classes for LoginPage, FreeStuffPage, MusicInstrumentsPage, and ItemPage.
- `tests/TestPage.java` → Contains 3 professional test cases.
- `pom.xml` → Maven dependencies and configuration.

## Features

- **Login Automation**: Automatically logs into the website before tests.
- **Category Navigation**: Navigates to the correct sub-category under "Free Stuff."
- **Live Monitoring**: Checks for new ads every 5 minutes (continuous refresh).
- **Item Requesting**: Requests new items when detected.
- **Assertions**: 
  - Verifies navigation to the correct category.
  - Ensures the new item is posted less than 1 hour ago.
  - Confirms the item has been requested (by checking the comment section).

## Test Cases

1. **Category Verification**:  
   Verify that the user is in "Free Stuff → Music Instruments & Equipment".

2. **New Item Detection**:  
   Verify that the newly posted item is less than 1 hour old.

3. **Request Confirmation**:  
   Verify that the item has been successfully requested (comment confirmation).

