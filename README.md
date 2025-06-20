# Low Level Design (LLD) Practice

This repository contains my active learning journey in Low Level Design (LLD), inspired by [codewitharyan.com/system-design/low-level-design](https://codewitharyan.com/system-design/low-level-design). I believe in learning by doing and solving real-world problems.

## Structure

The code is organized within the `src/main/java/com/learn/lld/` directory, following package structure based on topics and problem levels.

- Each **major topic** has a corresponding package (e.g., `baiscs`, `designPrincipal`).
- Inside each topic package:
  - A `problem.txt` file describes the problems for that topic, often split into levels.
  - Sub-packages (`problem1`, `problem2` for `baiscs`, `level1`, `level2` for `designPrincipal`) contain the Java implementations for the problems/levels.
- The `src/test/java/com/learn/lld/` directory contains unit tests for the implementations.

### Topics Covered:

- **Basic Concepts (`baiscs`)**:
  - Problem 1.1: Online Shopping Cart
  - Problem 1.2: Simple ATM Simulation
- **Design Principles (`designPrincipal`)**:
  - Level 1: Basic E-commerce Order Processing (Focus on SRP, OCP, DIP, KISS, YAGNI)
  - Level 2: Extending E-commerce with Notification and Shipping (Focus on LSP, ISP, DRY, and reinforcing Level 1 principles)

## Workflow

1. **Read** the problem statement in the relevant `problem.txt` file.
2. **Implement** the solution in the corresponding Java package/level.
3. **Ask AI** (e.g., GitHub Copilot) to review my code and suggest improvements.
4. **Test** the solution using the unit tests in the `src/test/java/` directory.

## Example Structure

```
low_level_design/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── learn/
│   │               └── lld/
│   │                   ├── baiscs/
│   │                   │   ├── problem.txt
│   │                   │   ├── problem1/
│   │                   │   │   ├── Product.java
│   │                   │   │   └── ShoppingCart.java
│   │                   │   └── problem2/
│   │                   │       ├── Atm.java
│   │                   │       └── BankAccount.java
│   │                   └── designPrincipal/
│   │                       ├── problem.txt
│   │                       ├── level1/
│   │                       │   ├── Cart.java
│   │                       │   ├── Cost/...
│   │                       │   ├── checkout/...
│   │                       │   ├── payment/...
│   │                       │   ├── Ecommerce.java
│   │                       │   └── Product.java
│   │                       └── level2/
│   │                           ├── notification/...
│   │                           ├── orderStatus/...
│   │                           └── shipping/...
│   └── test/
│       └── java/
│           └── com/
│               └── learn/
│                   └── lld/
│                       ├── baiscs/
│                       │   └── problem1/
│                       │       └── ShoppingCartTest.java // Example test file
│                       └── designPrincipal/
│                           └── level1/
│                               └── EcommerceTest.java
└── README.md
```
*(Note: The example structure is illustrative and may not list every single file)*

## How to Use

- Navigate to a topic package under `src/main/java/com/learn/lld/`.
- Read the `problem.txt` to understand the requirements.
- Explore the implementation files within the level/problem sub-packages.
- Run the corresponding tests in `src/test/java/com/learn/lld/` to verify the logic.

---
Happy Learning!
