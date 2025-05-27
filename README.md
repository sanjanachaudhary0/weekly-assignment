# weekly-assignment
# Rural Bank Account Management System (RBAMS)

## Overview

RBAMS is a console-based Java application for basic banking operations for the Rural Bank of Nepal. It supports Savings and Current accounts, custom exception handling, and demonstrates OOP principles.

## OOP Concepts Applied

- **Abstraction:** `BankAccount` is an abstract class; `withdraw` is an abstract method.
- **Inheritance:** `SavingsAccount` and `CurrentAccount` extend `BankAccount`.
- **Encapsulation:** All data members are private or protected; accessed via getters/setters.
- **Polymorphism:** Operations like deposit and withdraw are called on abstract `BankAccount` references.
- **Aggregation:** `Customer` class holds multiple `BankAccount` objects.

## Exception Handling

- Custom `InsufficientBalanceException` is thrown for invalid withdrawals (over balance or overdraft).

## Operations Supported

- Deposit to any account
- Withdraw with rule validation
- View all accounts and balances
- Add interest to Savings Account
- Overdraft for Current Account

## How to Run

1. Compile all `.java` files:
   ```
   javac *.java
   ```
2. Run:
   ```
   java RuralBankApp
   ```
