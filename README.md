# 📟 String Calculator - TDD Kata (Java)

A clean and well-tested Java implementation of the **String Calculator Kata**, built using the principles of **Test-Driven Development (TDD)**.  
This project is part of the Incubyte Software Craftsmanship Assessment and demonstrates commitment to quality, clarity, and robust handling of inputs.

---

## ✅ Features Implemented

| Step | Feature Description |
|------|---------------------|
| 1.1  | Return 0 for empty string |
| 1.2  | Return number itself for single input |
| 1.3  | Support comma-separated numbers |
| 2    | Support any number of values |
| 3    | Allow newline (`\n`) as a delimiter |
| 4    | Support custom single-character delimiters via header (e.g., `//;\n1;2`) |
| 5-6  | Throw exception for negative numbers and list all in the message |
| 7    | `getCalledCount()` method returns number of times `add()` was called |
| 9    | Ignore numbers greater than 1000 |
| 10   | Support custom delimiters of any length (e.g., `//[***]\n1***2***3`) |
| 11   | Support multiple single-character delimiters (e.g., `//[*][%]\n1*2%3`) |
| 12   | Support multiple multi-character delimiters (e.g., `//[**][%%]\n1**2%%3`) |

---

## ❌ Strict Delimiter Format Enforced

This implementation strictly follows the TDD Kata specification:
- Multi-character delimiters **must** be enclosed in square brackets (`[ ]`)
- Example:
  - ✅ Valid: `//[***]\n1***2***3`
  - ❌ Invalid: `//***\n1***2***3` → throws `IllegalArgumentException`

---

## 🧪 Test Suite (JUnit 5)

The project includes a comprehensive set of **positive and negative** test cases using **JUnit 5**, all located in:
`src/test/java/com/incubyte/StringCalculatorTest.java`

### ✔️ Positive Test Highlights:
- Handles empty, single, and multiple values
- Supports various delimiters (`,`, `\n`, custom ones)
- Ignores numbers over 1000
- Tracks how many times `add()` was invoked

### ❌ Negative Test Highlights:
- Rejects unbracketed multi-character delimiters
- Throws on negative numbers with detailed messages
- Fails on non-numeric inputs
- Throws exception for null inputs

---

## 🧠 Design Principles

- 🔁 **TDD-first**: every feature is written test-first
- 🧼 **Clean, readable Java code**
- 🧪 **Well-separated test cases** for clarity
- 🔒 **Strict validation rules** to match problem spec

---

## 🧰 Tech Stack

- Java 17+
- JUnit 5
- IntelliJ IDEA (recommended)
- Git (with step-by-step commits)

---

## 📂 Project Structure

```
src/
├── main/
│ └── java/com/incubyte/
│ └── StringCalculator.java # Business logic
├── test/
│ └── java/com/incubyte/
│ └── StringCalculatorTest.java # JUnit test suite
```

---

## ▶️ How to Run Tests (in IntelliJ)

1. Right-click `StringCalculatorTest` class.
2. Select **Run 'StringCalculatorTest'**.
3. View results in the output/test panel.

---

## 💡 Sample Usage

```java
StringCalculator calc = new StringCalculator();
int result = calc.add("1,2\n3"); // returns 6
int count = calc.getCalledCount(); // returns 1
```
---

## 📎 References
- [TDD Kata blog by Incubyte](https://blog.incubyte.co/blog/tdd-assessment/)
- [TDD Kata by Roy Osherove](https://osherove.com/tdd-kata-1)

---

Crafted and Maintained with ❤️ by [Jeet Bhuptani](https://jeetbhuptani.me)
