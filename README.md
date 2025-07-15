# Selenium 2FA Automation with Virtual Authenticator & TOTP

This project demonstrates how to automate login flows involving **hardware-based (FIDO2/USB)** and **TOTP-based (Google Authenticator, Duo, Microsoft Authenticator)** two-factor authentication (2FA) using **Selenium WebDriver in Java**.

It leverages:
- `HasVirtualAuthenticator` from Selenium WebDriver for simulating USB key/fingerprint-based FIDO2 devices.
- `GoogleAuthenticator` (`com.warrenstrange:googleauth:1.4.0`) for generating time-based one-time passwords (TOTP) from shared secret keys.

It includes:
- A **virtual authenticator test** that simulates USB-based FIDO2 login using Selenium’s `HasVirtualAuthenticator` interface.
- A real-world **login test to Workplace by Meta using sample credentials and dynamic **TOTP code generation** via `GoogleAuthenticator` library.

## 🎯 Key Features

- Emulates **FIDO2/WebAuthn** USB authentication via virtual authenticator.
- Generates and fills **TOTP-based 2FA codes** from secret keys.
- Complete automation of 2FA-protected login flows using only Java + Selenium.

## 🧩 Tech Stack

- Java 11+
- Maven
- Selenium WebDriver 4.10+
- Google Authenticator Java library
- JUnit 4 / TestNG (your choice)

## 🗂️ Structure

```
src/
├── main/java/
│   ├── totp/                         # Generates TOTP codes using secret
│   │   └── TOTPGenerator.java
│   └── helper/
│       ├── BaseTestClass.java
│       └── PropertiesReader.java
├── test/java/
│   └── auth/
│       ├── TestWebAuthn.java         # Simulates FIDO2 device
│       └── WorkplaceLoginTest.java   # Real login to Workplace
├── test/
│   └── resources/
│       └── wp-login.properties
```

## ▶️ How to Run

1. Clone the repository  
2. Add your secret key & URL in the wp-login.properties file  
3. Run the test with:
```bash
mvn clean test
```

> Requires Chrome and Java 11+ installed.

## 📌 Notes

- The `HasVirtualAuthenticator` API is supported only in **Selenium 4.10+**
- Set your email, password, url and 2FA secret inside **wp-login.properties** for the test to work correctly.
- This repo is for **educational and demonstration purposes only**. Never misuse security automation on protected systems.

---

## 📘 References

- Selenium Virtual Authenticator: https://www.selenium.dev/documentation/webdriver/webauthn/
- Google Authenticator Java lib: https://github.com/wstrange/GoogleAuth

---

## 🔐 License

MIT License - free for personal and educational use.
