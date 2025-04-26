# Adverts.ie Free Stuff Monitor 🎸

This is a Selenium-Java-Maven automated testing project that monitors the "Free Stuff" section on [Adverts.ie](https://www.adverts.ie/), specifically the "Music Instruments & Equipment" subcategory.

The project checks every 5 minutes for newly posted items.  
When a new item appears, it automatically requests it and verifies the request by checking the comment section.

---

## 🛠 Built With

- Java 17+
- Selenium WebDriver 4.19
- Maven
- JUnit 5

---

## 📋 Project Structure (POM)

```bash
adverts-monitor/
│
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       ├── base/
    │       │   └── BaseTest.java
    │       ├── pages/
    │       │   ├── HomePage.java
    │       │   ├── LoginPage.java
    │       │   ├── FreeStuffPage.java
    │       │   └── ItemPage.java
    └── test/
        └── java/
            └── tests/
                └── TestPage.java


How It Works
Logs in automatically (credentials are to be inserted manually into LoginPage.java).

Navigates to:

"Free Stuff" category

"Music Instruments & Equipment" subcategory

Loops:

Refreshes the page every 5 minutes

Monitors for newly added items (posted less than 1 hour ago)

When a new item is found:

Selects the item

Sends a request

Confirms the request by checking the comment section.

✅ Test Cases Included
Assert that the user is correctly navigated to "Music Instruments & Equipment".

Assert that a new item is published less than 1 hour ago.

Assert that the request is successfully posted.

🧩 Requirements
Chrome browser installed

ChromeDriver placed manually in the project (or in PATH)

Maven installed

JDK 17+ installed

---------How to Run-----------------
bash
Copiar
Editar
# Clone the project
git clone https://github.com/YOUR_USERNAME/adverts-monitor.git

# Navigate into project directory
cd adverts-monitor

# Run the tests with Maven
mvn clean test